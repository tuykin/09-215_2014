create table numberoflessons(

section_id int not null,
client_id int not null,
number int not null check(number>=0),
constraint fk_section_id_nol_sec 
foreign key(section_id)
references sections(id),
constraint fk_client_id_nol_cli 
foreign key(client_id)
references clients(id)

)