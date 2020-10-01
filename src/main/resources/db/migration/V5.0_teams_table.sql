CREATE TABLE `teams` (

	`team_id` BIGINT AUTO_INCREMENT,
	`student_id` BIGINT,
	`professor_id` BIGINT,
	PRIMARY KEY (`team_id`, `student_id`),
    CONSTRAINT team_student_fk FOREIGN KEY(`student_id`) REFERENCES students(`user_id`),
    CONSTRAINT team_professor_fk FOREIGN KEY(`professor_id`) REFERENCES professors(`user_id`)
);