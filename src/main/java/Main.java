import lab1.HibernateMetadataProvider;
import lab3.JoinedTable.utils.JoinedParser;
import lab3.Mapped.utils.MappedParser;
import lab3.SingleTable.utils.STableParser;
import lab3.TablePerClass.utils.PerClassParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.Constants;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class Main {
    private static final Logger log = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws IOException{
        log.info(String.join(",", args));
        if (args.length < 1) {
            log.error(Constants.NO_ARGS);
            return;
        }
        switch (Integer.parseInt(args[0])) {
            case 1:
                HibernateMetadataProvider dp1 = new HibernateMetadataProvider();
                System.out.print(dp1.getSchema());
                System.out.print(dp1.getSchemaName());
                System.out.print(dp1.getTables());
                System.out.print(dp1.getDetails());
                break;
            case 3:
                switch (args[1].toUpperCase(Locale.ROOT)){
                    case "JOINED":
                        lab3.JoinedTable.api.HibernateEntityProvider lr33 = new lab3.JoinedTable.api.HibernateEntityProvider();
                        switch (args[2].toUpperCase(Locale.ROOT)) {
                            case "CREATE":
                                if (args.length>3){
                                    lab3.JoinedTable.models.SprinterTraining sprinterTraining = JoinedParser.getSprinterTraining(args[3]);
                                    sprinterTraining = lr33.createSprTraining(sprinterTraining);
                                    log.info(sprinterTraining);
                                } else {
                                    log.error(Constants.TOO_FEW_ARGS);
                                }
                                break;
                            case "GET":
                                List<lab3.JoinedTable.models.SprinterTraining> sprinterTrainingList = lr33.getSprTrainings();
                                log.info(sprinterTrainingList);
                                break;
                            case "GETBYID":
                                if (args.length > 2) {
                                    try {
                                        Long id = Long.parseLong(args[3]);
                                        lab3.JoinedTable.models.SprinterTraining sprinterTraining = lr33.getSprTrainingById(id);
                                        log.info(sprinterTraining);
                                    } catch (Exception e) {
                                        log.error(Constants.BAD_ARGS);
                                    }
                                    } else {
                                    log.error(Constants.TOO_FEW_ARGS);
                                }
                                break;
                            case "DELETE":
                                if (args.length > 2) {
                                    try {
                                        Long id = Long.parseLong(args[3]);
                                        log.info(lr33.deleteSprTrainings(id));
                                    } catch (Exception e) {
                                        log.error(Constants.BAD_ARGS);
                                    }
                                }
                                break;
                            case "UPDATE":
                                if (args.length > 2) {
                                    try {
                                        lab3.JoinedTable.models.SprinterTraining sprinterTraining = JoinedParser.getSprinterTraining(args[3]);
                                        sprinterTraining = lr33.updateSprTraining(sprinterTraining);
                                        log.info(sprinterTraining);
                                    } catch (Exception e) {
                                        log.error(Constants.BAD_ARGS);
                                    }
                                } else {
                                    log.error(Constants.TOO_FEW_ARGS);
                                }
                                break;
                        }
                    case "MAPPED":
                        lab3.Mapped.api.HibernateEntityProvider lr31 = new lab3.Mapped.api.HibernateEntityProvider();
                        switch (args[2].toUpperCase(Locale.ROOT)) {
                            case "CREATE":
                                if (args.length>4){
                                    lab3.Mapped.models.SprinterTraining sprinterTraining = MappedParser.getSprinterTraining(args[3]);
                                    sprinterTraining = lr31.createSprTraining(sprinterTraining);
                                    log.info(sprinterTraining);
                                } else {
                                    log.error(Constants.TOO_FEW_ARGS);
                                }
                                break;
                            case "GET":
                                List<lab3.Mapped.models.SprinterTraining> sprinterTrainingList = lr31.getSprTrainings();
                                log.info(sprinterTrainingList);
                                break;
                            case "GETBYID":
                                if (args.length > 2) {
                                    try {
                                        Long id = Long.parseLong(args[3]);
                                        lab3.Mapped.models.SprinterTraining sprinterTraining = lr31.getSprTrainingById(id);
                                        log.info(sprinterTraining);
                                    } catch (Exception e) {
                                        log.error(Constants.BAD_ARGS);
                                    }
                                } else {
                                    log.error(Constants.TOO_FEW_ARGS);
                                }
                                break;
                            case "DELETE":
                                if (args.length > 2) {
                                    try {
                                        Long id = Long.parseLong(args[3]);
                                        log.info(lr31.deleteSprTrainings(id));
                                    } catch (Exception e) {
                                        log.error(Constants.BAD_ARGS);
                                    }
                                }
                                break;
                            case "UPDATE":
                                if (args.length > 2) {
                                    try {
                                        lab3.Mapped.models.SprinterTraining sprinterTraining = MappedParser.getSprinterTraining(args[3]);
                                        sprinterTraining = lr31.updateSprTraining(sprinterTraining);
                                        log.info(sprinterTraining);
                                    } catch (Exception e) {
                                        log.error(Constants.BAD_ARGS);
                                    }
                                } else {
                                    log.error(Constants.TOO_FEW_ARGS);
                                }
                                break;
                        }
                    case "SINGLETABLE":
                        lab3.SingleTable.api.HibernateEntityProvider lr32 = new lab3.SingleTable.api.HibernateEntityProvider();
                        switch (args[1].toUpperCase(Locale.ROOT)) {
                            case "CREATE":
                                if (args.length>4){
                                    lab3.SingleTable.models.SprinterTraining sprinterTraining = STableParser.getSprinterTraining(args[3]);
                                    sprinterTraining = lr32.createSprTraining(sprinterTraining);
                                    log.info(sprinterTraining);
                                } else {
                                    log.error(Constants.TOO_FEW_ARGS);
                                }
                                break;
                            case "GET":
                                List<lab3.SingleTable.models.SprinterTraining> sprinterTrainingList = lr32.getSprTrainings();
                                log.info(sprinterTrainingList);
                                break;
                            case "GETBYID":
                                if (args.length > 2) {
                                    try {
                                        Long id = Long.parseLong(args[3]);
                                        lab3.SingleTable.models.SprinterTraining sprinterTraining = lr32.getSprTrainingById(id);
                                        log.info(sprinterTraining);
                                    } catch (Exception e) {
                                        log.error(Constants.BAD_ARGS);
                                    }
                                } else {
                                    log.error(Constants.TOO_FEW_ARGS);
                                }
                                break;
                            case "DELETE":
                                if (args.length > 2) {
                                    try {
                                        Long id = Long.parseLong(args[3]);
                                        log.info(lr32.deleteSprTrainings(id));
                                    } catch (Exception e) {
                                        log.error(Constants.BAD_ARGS);
                                    }
                                }
                                break;
                            case "UPDATE":
                                if (args.length > 2) {
                                    try {
                                        lab3.SingleTable.models.SprinterTraining sprinterTraining = STableParser.getSprinterTraining(args[3]);
                                        sprinterTraining = lr32.updateSprTraining(sprinterTraining);
                                        log.info(sprinterTraining);
                                    } catch (Exception e) {
                                        log.error(Constants.BAD_ARGS);
                                    }
                                } else {
                                    log.error(Constants.TOO_FEW_ARGS);
                                }
                                break;
                        }
                    case "TABLEPERCLASS":
                        lab3.TablePerClass.api.HibernateEntityProvider lr34 = new lab3.TablePerClass.api.HibernateEntityProvider();
                        switch (args[2].toUpperCase(Locale.ROOT)) {
                            case "CREATE":
                                if (args.length>4){
                                    lab3.TablePerClass.models.SprinterTraining sprinterTraining = PerClassParser.getSprinterTraining(args[3]);
                                    sprinterTraining = lr34.createSprTraining(sprinterTraining);
                                    log.info(sprinterTraining);
                                } else {
                                    log.error(Constants.TOO_FEW_ARGS);
                                }
                                break;
                            case "GET":
                                List<lab3.TablePerClass.models.SprinterTraining> sprinterTrainingList = lr34.getSprTrainings();
                                log.info(sprinterTrainingList);
                                break;
                            case "GETBYID":
                                if (args.length > 2) {
                                    try {
                                        Long id = Long.parseLong(args[3]);
                                        lab3.TablePerClass.models.SprinterTraining sprinterTraining = lr34.getSprTrainingById(id);
                                        log.info(sprinterTraining);
                                    } catch (Exception e) {
                                        log.error(Constants.BAD_ARGS);
                                    }
                                } else {
                                    log.error(Constants.TOO_FEW_ARGS);
                                }
                                break;
                            case "DELETE":
                                if (args.length > 2) {
                                    try {
                                        Long id = Long.parseLong(args[3]);
                                        log.info(lr34.deleteSprTrainings(id));
                                    } catch (Exception e) {
                                        log.error(Constants.BAD_ARGS);
                                    }
                                }
                                break;
                            case "UPDATE":
                                if (args.length > 2) {
                                    try {
                                        lab3.TablePerClass.models.SprinterTraining sprinterTraining = PerClassParser.getSprinterTraining(args[3]);
                                        sprinterTraining = lr34.updateSprTraining(sprinterTraining);
                                        log.info(sprinterTraining);
                                    } catch (Exception e) {
                                        log.error(Constants.BAD_ARGS);
                                    }
                                } else {
                                    log.error(Constants.TOO_FEW_ARGS);
                                }
                                break;
                        }
                }
        }
    }
}
