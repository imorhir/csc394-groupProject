CREATE TABLE `students` (

	`user_id` BIGINT NOT NULL,

	PRIMARY KEY (`user_id`),
    CONSTRAINT user_fk FOREIGN KEY(`user_id`) REFERENCES users(`user_id`)
);