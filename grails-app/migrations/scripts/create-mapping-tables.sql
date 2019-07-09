CREATE TABLE IF NOT EXISTS `tfdb`.`project_user_mapping` (
  `project_project_id` INT NOT NULL,
  `user_user_id` INT NOT NULL,
  PRIMARY KEY (`project_project_id`, `user_user_id`),
  INDEX `fk_project_has_user_user1_idx` (`user_user_id` ASC),
  INDEX `fk_project_has_user_project_idx` (`project_project_id` ASC),
    FOREIGN KEY (`project_project_id`)
    REFERENCES `tfdb`.`project` (`project_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    FOREIGN KEY (`user_user_id`)
    REFERENCES `tfdb`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;