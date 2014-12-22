insert into users (login,password_hash,email) values
('highsepton','6e73ec475180bd8fface67da4e06cb10','lolita111@ya.ru'),
('XKingStannisX','68c1182020e1796322478ecd787e4ee2','hardestman@dragonstone.com'),
('LiKeAgIrl111','b114fa6f2fd0be01c0c50a4531e5cbcc','stupid.bastard@rambler.ru'),
('KingOfNorth007','cc34018e9c28add354bccbd81f6f3968','winteriscuming@gmail.com'),
('meATh00kER','a504290628156b08ab14927d5bc22f6c','rooooose4ka@mail.ru');

/*password for entering!*/
/*insert into Passwords values
(1,'top7ecretMMM'),
(2,'1s2t3a4n'),
(3,'lalka'),
(4,'5TARK5areBest'),
(5,'myC11kISbig123');*/

insert into resumes values
(1,1,'Animator',35,'java, c#, c++','recent job in company "BratstvoBezZnamen ltd." as a tester of applications for Android');

insert into projects values
(1,'War Behind The Wall: White Walkers Are Coming','RPG','MMORPG','PC','we are cool guys, join us',2,2),
(2,'Crossbow Simulator','Simulation','Simulation sport','Game Console','hey hey bow masters, come here',3,2);

insert into announcements values
(1,1,'QATester'),
(2,2,'Game Designer'),
(3,1,'Level Editor');

insert into users_in_projects values
(1,2,1),
(2,3,2),
(3,5,2),
(4,4,1),
(5,1,1),
(6,1,2);

insert into user_requests values
(1,3,1);

insert into project_requests values
(1,2,2);