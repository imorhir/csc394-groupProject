CREATE TABLE `ratings` (

	`rating_id` BIGINT AUTO_INCREMENT,
	`rate_val` INT,
	`message` VARCHAR(511),
	`rater_id` BIGINT,
	`ratee_id` BIGINT,
	PRIMARY KEY (`rating_id`),
    CONSTRAINT rater_fk FOREIGN KEY(`rater_id`) REFERENCES users(`user_id`),
    CONSTRAINT rater_fk FOREIGN KEY(`ratee_id`) REFERENCES users(`user_id`)
);