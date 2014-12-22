delimiter $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_user_main_data`(in login_p varchar(20), 
	in pass_hash_p varchar(32), in email_p varchar(45))
begin
	set @login_p = login_p;
	set @pass_hash_p = pass_hash_p;
	set @email_p = email_p;
	set @s = 'insert into users (login,password_hash,email) values (?,@pass_hash_p,@email_p)';
	prepare stmt from @s;
	execute stmt using @login_p;
end$$

delimiter $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `select_announcements_by_params`(in proj_name_p varchar(60),
	in position_p varchar(35), in global_genre_p varchar(10), in genre_p varchar(30),
	in platform1 varchar(12), in platform2 varchar(12), in platform3 varchar(12))
begin
	set @proj_name_p = proj_name_p;
	set @position_p = position_p;
	set @global_genre_p = global_genre_p;
	set @genre_p = genre_p;
	set @platform1 = platform1, @platform2 = platform2, @platform3 = platform3;
	set @s = 'select proj_name, position, global_genre, genre, platforms, count from 
projects, announcements where 
proj_name like concat(?,\'%\') and 
position like concat(@position_p,\'%\') and 
global_genre like concat(@global_genre_p,\'%\') and 
genre like concat(@genre_p,\'%\') and 
platforms like concat(\'%\', @platform1, @platform2, @platform3,\'%\')';
	prepare stmt from @s;
	execute stmt using @proj_name_p
;
end$$

delimiter $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `select_users_by_email`(in email_p varchar(45))
begin
	set @email_p = email_p;
	set @s = 'select * from users where email=?';
	prepare stmt from @s;
	execute stmt using @email_p;
end$$

delimiter $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `select_users_by_login`(in login_p varchar(20))
begin
	set @login_p = login_p;
	set @s = 'select * from users where login=?';
	prepare stmt from @s;
	execute stmt using @login_p;
end$$

