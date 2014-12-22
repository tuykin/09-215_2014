create table enddates(

client_id int not null,
section_id int not null,
endDate date not null,
typeOfSub_id int not null,
constraint fk_client_id_end_cli
foreign key(client_id)
references clients(id)
on delete cascade
on update cascade,
constraint fk_section_id_end_sec
foreign key(section_id)
references sections(id)
on delete cascade
on update cascade,
constraint fk_typeOfSub_id_end_tos
foreign key(typeOfSub_id)
references typesofsub(id)

);