package main;

import com.avaje.ebean.config.Platform;
import com.avaje.ebean.dbmigration.DbMigration;

import java.io.IOException;

/**
 * Generate the DB Migration.
 */
public class MainDbMigration {

  public static void main(String[] args) throws IOException, InterruptedException {

    //System.setProperty("ddl.migration.version", "1.2_33");
    //System.setProperty("ddl.migration.name", "");

    //System.setProperty("ddl.migration.pendingDropsFor", "1.1");
    //System.setProperty("ddl.migration.pendingDrop", "1.1");

    DbMigration dbMigration = new DbMigration();
    dbMigration.setPlatform(Platform.POSTGRES);

    // generate the migration xml and ddl
    dbMigration.generateMigration();
  }
}