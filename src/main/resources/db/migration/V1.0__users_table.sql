CREATE TABLE `roles` (
	`role_id` BIGINT AUTO_INCREMENT,
    `role_name` VARCHAR(255),
	`role_code` VARCHAR (255),
	 PRIMARY KEY (`role_id`)

);

create table `teams`(

    `team_id` BIGINT AUTO_INCREMENT,
    `user_id` INT ,
    `team_name` varchar (255),
    PRIMARY KEY (`team_id`)
);

CREATE TABLE `reviews` (
	`review_id` BIGINT AUTO_INCREMENT,
    `team_id` INT,
    `user_id` INTEGER,
    `rating` INTEGER,
	PRIMARY KEY (`review_id`)
);


CREATE TABLE `users` (
	`user_id` BIGINT AUTO_INCREMENT,
    `user_email` VARCHAR(255),
	`first_name` VARCHAR(255),
    `last_name` VARCHAR(255),
    `role_id`    BIGINT,
	`user_name` VARCHAR(255),
	`pass_word` VARCHAR(255),
    `team_id`    BIGINT,
	 PRIMARY KEY (`user_id`)
);

create table `goals`(

    `goal_id` BIGINT AUTO_INCREMENT,
    `goal_discription` VARCHAR (255),
    `team_id` BIGINT,
    `grades` BIGINT,
--     `status` varchar (255),
    PRIMARY KEY (`goal_id`)
);


insert into `users` (`user_id`, `user_email`, `first_name`, `last_name`,`role_id`,`user_name`, `pass_word`, `team_id`) values (null,'admin@admin.com', 'sam', 'moe', '1', 'sahtout', 'khamla','1');
insert into `users` (`user_id`, `user_email`, `first_name`, `last_name`,`role_id`,`user_name`, `pass_word`, `team_id`) values (null,'@admin.com', 'mas', 'emfdv', '2', 'saht', 'kha',null );

insert into `roles` (`role_id`, `role_name`, `role_code`) values (null, 'ADMIN', 'admin');
insert into `roles` (`role_id`, `role_name`, `role_code`) values (null, 'FACULTY', 'faculty');
insert into `roles` (`role_id`, `role_name`, `role_code`) values (null, 'STUDENT', 'student');

insert into `teams` (`team_id`, `user_id`, `team_name`) values (null, null, 'apolo');
insert into `goals` (`goal_id`, `goal_discription`, `team_id`, `grades`) values (null, 'hello world',1,100);
insert into `goals` (`goal_id`, `goal_discription`, `team_id`, `grades`) values (null, 'hello world2',1,99);
insert into `reviews` (`review_id`, `team_id`, `user_id`, `rating`) values (null, 1, 1, 3);

ALTER TABLE `Teams`
ADD CONSTRAINT teams_fk foreign KEY (`user_id`) references users(`user_id`);
ALTER TABLE `reviews`
ADD CONSTRAINT reviews_fk foreign KEY (`team_id`) REFERENCES teams(`team_id`);
ALTER TABLE `reviews`
ADD CONSTRAINT review_f foreign KEY (`user_id`) REFERENCES users(`user_id`);
ALTER TABLE `users`
ADD CONSTRAINT user_fk foreign KEY (`role_id`) REFERENCES roles(`role_id`);
ALTER TABLE `users`
ADD CONSTRAINT user_fk2 foreign KEY (`team_id`) REFERENCES teams(`team_id`);
ALTER TABLE `goals`
ADD CONSTRAINT goals_fk foreign KEY (`team_id`) REFERENCES teams(`team_id`);