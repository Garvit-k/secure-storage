package database;

import com.mongodb.*;

import java.net.UnknownHostException;

public class DBHelper {
    MongoClient mongoClient;
    DB database;
    private void initConnection() throws UnknownHostException {
        if (mongoClient==null) {
            mongoClient = new MongoClient();
        }
    }
    private void setDatabase() throws UnknownHostException {
        initConnection();
        if (database == null) {
            database = mongoClient.getDB("securestorage");
        }
    }
    private DBCollection getCollection(String collection) throws UnknownHostException {
        setDatabase();
        return database.getCollection(collection);
    }
    public void insert(String collection, DBObject object) throws UnknownHostException {
        DBCollection dbCollection = getCollection(collection);
        dbCollection.insert(object);
    }
    public DBObject fetch(String collection,DBObject query) throws UnknownHostException {
        DBCollection collection1 = getCollection(collection);
        DBCursor cursor = collection1.find(query);
        return cursor.one();
    }

}
