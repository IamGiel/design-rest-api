#### Table Structure

create table user (
	id integer not null, 
	birthday timestamp, 
	name varchar(255), 
	primary key (id)
)

#### Create Post Entity 
Post has ManyToOne relationship syntaxed by  `@ManyToOne(fetch=FetchType.LAZY)`
User has oneToMany relationship `@OneToMany(mappedBy="user")`
