# code-climb-jwt
JWT Authentication in Spring Boot

Table CREATE Code:

```
CREATE TABLE `user` (
	`user_id` INT NOT NULL AUTO_INCREMENT,
	`username` VARCHAR(50) NOT NULL DEFAULT '' COLLATE 'utf8mb4_0900_ai_ci',
	`password` TEXT NOT NULL COLLATE 'utf8mb4_0900_ai_ci',
	`name` TEXT NOT NULL COLLATE 'utf8mb4_0900_ai_ci',
	`created_at` DATETIME NULL DEFAULT (now()),
	`updated_at` DATETIME NULL DEFAULT (now()),
	PRIMARY KEY (`user_id`) USING BTREE,
	UNIQUE INDEX `username` (`username`) USING BTREE
)
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB
AUTO_INCREMENT=3
;
```

You can generate HMAC SHA-256 secret using [this](https://www.akto.io/tools/hmac-sha-256-hash-generator) website.
