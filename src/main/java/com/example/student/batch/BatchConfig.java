package com.example.student.batch;

import com.example.student.model.Student;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class BatchConfig {

    @Bean
    public FlatFileItemReader<Student> reader() {
        FlatFileItemReader<Student> reader = new FlatFileItemReader<>();
        reader.setResource(new ClassPathResource("student.csv"));
        reader.setLinesToSkip(1); // skip header

        DefaultLineMapper<Student> mapper = new DefaultLineMapper<>();

        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
        tokenizer.setNames("student_name", "student_email", "student_branch");

        BeanWrapperFieldSetMapper<Student> fieldSetMapper =
                new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(Student.class);

        mapper.setLineTokenizer(tokenizer);
        mapper.setFieldSetMapper(fieldSetMapper);

        reader.setLineMapper(mapper);
        return reader;
    }


    @Bean
    public ItemProcessor<Student, Student> processor() {
        return student -> {
            student.setStudent_name(student.getStudent_name().toUpperCase());
            return student;
        };
    }

    @Bean
    public JpaItemWriter<Student> writer(EntityManagerFactory emf) {
        JpaItemWriter<Student> writer = new JpaItemWriter<>();
        writer.setEntityManagerFactory(emf);
        return writer;
    }

    @Bean
    public Step studentStep(JobRepository jobRepository,
                            PlatformTransactionManager transactionManager,
                            FlatFileItemReader<Student> reader,
                            ItemProcessor<Student, Student> processor,
                            JpaItemWriter<Student> writer) {

        return new StepBuilder("studentStep", jobRepository)
                .<Student, Student>chunk(50, transactionManager)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }

    @Bean
    public Job studentJob(JobRepository jobRepository, Step studentStep) {
        return new JobBuilder("studentJob", jobRepository)
                .start(studentStep)
                .build();
    }

    @Bean
    public CommandLineRunner run(JobLauncher jobLauncher, Job job) {
        return args -> {
            JobParameters params = new JobParametersBuilder()
                    .addLong("startAt", System.currentTimeMillis())
                    .toJobParameters();

            jobLauncher.run(job, params);
        };
    }


}

