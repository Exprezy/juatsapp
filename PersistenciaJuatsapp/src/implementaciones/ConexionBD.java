/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementaciones;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import interfaces.IConexionBD;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 *
 * @author aldom
 */
public class ConexionBD implements IConexionBD {

    public MongoDatabase crearConexion() throws Exception {
        String HOST = "localhost";
        String PUERTO = "27017";
        
        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
            
        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);

        ConnectionString cadenaConexion = new ConnectionString("mongodb://"+HOST+"/"+PUERTO);

        MongoClientSettings clientsSettings = MongoClientSettings.builder()
            .applyConnectionString(cadenaConexion)
            .codecRegistry(codecRegistry)
            .build();
        
        MongoClient dbServer = MongoClients.create(clientsSettings);
        MongoDatabase baseDatos = dbServer.getDatabase("juatsappdb");
        return baseDatos;
    }
    
    
}
