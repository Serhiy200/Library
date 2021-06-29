CREATE TABLE `category` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `category_name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC));

CREATE TABLE `books` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `book_name` VARCHAR(45) NOT NULL,
  `author` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  `id_category` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `categor_idx` (`id_category` ASC),
  CONSTRAINT `categor`
    FOREIGN KEY (`id_category`)
    REFERENCES `book`.`category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

