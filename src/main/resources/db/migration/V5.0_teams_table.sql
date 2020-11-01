CREATE TABLE `teams` (

	`team_id` BIGINT AUTO_INCREMENT,
	`student_id` BIGINT,
	`faculty_id` BIGINT,
	PRIMARY KEY (`team_id`, `student_id`),
    CONSTRAINT team_student_fk FOREIGN KEY(`student_id`) REFERENCES users(`user_id`),
    CONSTRAINT team_faculty_fk FOREIGN KEY(`faculty_id`) REFERENCES users(`user_id`)
);