package interfaceexample;

public class PostgreSQLDbProvider implements DbProvider{

    @Override
    public void connectToDb() {
        //some logic for Postgre
    }

    @Override
    public void disconnectFromDb() {
        //some logic for Postgre
    }

    @Override
    public void encryptData() {
        //some logic for Postgre
    }
}