# Hibernate-OneToMany-MappingXML
Hibernate OneToMany Mapping using Xml Configuration + Maven
# What is the real use of inverse keyword in hibernate

By default inverse="false" in a Hibernate, if you are not using inverse means false.
The real meaning of inverse keyword is that, defines which side is the parent relationship owner for the two entities (parent or child). 
Hence, inverse="true" in a Hibernate mapping shows that,
which entity is parent table, and that entity is resposible to maintain the relationship.
