package lab1;

import java.util.List;

public interface IMetadataProvider {
    List getSchema();

    List getTables();

    List getDetails();

    List getSchemaName();
}
