var db = connect("mongodb://mongoadmin:secret@localhost:27017/admin");

db = db.getSiblingDB('data');


db.createUser(
    {
        user: "user_service",
        pwd: "secret",
        roles: [ { role: "dbOwner", db: "data"}],
        passwordDigestor: "server",
		mechanisms: ["SCRAM-SHA-1","SCRAM-SHA-256"]
    }
);

db.createCollection('userDetails');
db.createCollection('userNotes');