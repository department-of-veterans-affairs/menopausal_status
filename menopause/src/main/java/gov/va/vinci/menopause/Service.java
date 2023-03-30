package gov.va.vinci.menopause;

import gov.va.vinci.menopause.pipeline.BasePipeline;
import gov.va.vinci.leo.descriptors.LeoAEDescriptor;
import gov.va.vinci.leo.descriptors.LeoTypeSystemDescription;
import gov.va.vinci.leo.tools.LeoUtils;
import gov.va.vinci.menopause.pipeline.ChexFunnel;
import groovy.util.ConfigObject;
import groovy.util.ConfigSlurper;
import org.apache.log4j.Logger;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.util.HashMap;


/**
 *
 * @author OVP
 *
 * Elite pipeline includes:
 * -- RegEx to search for Term
 * -- WindowAnnotator to detect window boundaries
 * -- Context to determine the Term context within the Window
 * -- AnnotationPatternAnnotator to detect additional context information
 *
 */
public class Service {
  private static final Logger log = Logger.getLogger(LeoUtils.getRuntimeClass().toString());

  @Option(name = "-serviceConfigFile", usage = "The groovy config file that defines the service properties. (only ONE allowed).", required = true)
  public File[] serviceConfigFile;

  @Option(name = "-pipeline", usage = "Select pipeline.", required = false)
  public String[] pipeline;

  int numberOfInstances = 1;
  boolean isAsync = false;
  HashMap<String, Object> serviceArgs;

  public Service() {
    serviceArgs = new HashMap<String, Object>();
  }
  private gov.va.vinci.leo.Service service;
  
  /**
   * @param args
   */
  
  public static void main(String[] args) {
    gov.va.vinci.menopause.Service current_service = new gov.va.vinci.menopause.Service();
    if (args.length == 0) {
      current_service.serviceConfigFile = new File[]{new File("config/ServerConfig.groovy")};
      current_service.pipeline = new String[]{"gov.va.vinci.menopause.pipeline.Pipeline"};
    } else {
      CmdLineParser parser = new CmdLineParser(current_service);
      try {
        parser.parseArgument(args);
      } catch (CmdLineException e) {
        printUsage();
        System.exit(1);
      }
    }
    current_service.run();
  }
  
  public static void printUsage() {
    CmdLineParser parser = new CmdLineParser(new Service());
    System.out.print("Usage: java " + Service.class.getCanonicalName());
    parser.printSingleLineUsage(System.out);
    System.out.println();
    parser.printUsage(System.out);
    
  }
  public void stopService( ) {
    try {
      this.service.undeploy();
      //System.exit(1);
    } catch (Exception e) {
      System.out.println("Service is stopped in Service class");
      e.printStackTrace();
    }
  }
  public void run() {
    log.info(" \r\n \r\n ===  Starting Service " + LeoUtils.getTimestampDateDotTime() + " ====\r\n  ");

    try {
       this.service = new gov.va.vinci.leo.Service();
      setServerProperties(service);
      
      LeoAEDescriptor aggregate = new LeoAEDescriptor();
      LeoTypeSystemDescription types = new LeoTypeSystemDescription();
      
      /** Create an aggregate of the components. */
      for (String line : pipeline) {
        Class pipe = Class.forName(line);
        Constructor<?> constructor = pipe.getConstructor(HashMap.class);
        BasePipeline pipeInstance = (BasePipeline) constructor.newInstance(serviceArgs);
        System.out.println("Adding pipeline: " + pipeInstance.getClass().getCanonicalName());
        aggregate.addDelegate(pipeInstance.getPipeline());

      /* create type system */
        types.addTypeSystemDescription(pipeInstance.getLeoTypeSystemDescription());
      }

      aggregate.setIsAsync(isAsync);
      aggregate.setNumberOfInstances(numberOfInstances);

			/* Deploy the service. */
      service.deploy(aggregate);
      System.out.println("\r\nDeployment: " + service.getDeploymentDescriptorFile());
      System.out.println("Aggregate: " + service.getAggregateDescriptorFile());
  
      System.out.println("Service running, press enter in this console to stop.");
      System.in.read();
      service.undeploy();
      //System.exit(0);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  


  /**
   * Loading properties from configuration file
   *
   * @param leoServer
   * @return
   * @throws MalformedURLException
   * @throws InvocationTargetException
   * @throws IllegalAccessException
   */
  protected gov.va.vinci.leo.Service setServerProperties(gov.va.vinci.leo.Service leoServer) throws MalformedURLException,
      InvocationTargetException, IllegalAccessException {
    if (serviceConfigFile.length != 1) {
      return leoServer;
    }

    ConfigSlurper configSlurper = new ConfigSlurper();

    ConfigObject o = configSlurper.parse(serviceConfigFile[0].toURI().toURL());
    for (Object key : o.keySet()) {
      serviceArgs.put((String) key, o.get(key));
    }
    if (o.keySet().contains("brokerURL"))
      leoServer.setBrokerURL(o.get("brokerURL").toString());
    
    if (o.keySet().contains("endpoint"))
      leoServer.setEndpoint( o.get("endpoint").toString());
    
    if (o.keySet().contains("deleteOnExit"))
      leoServer.setDeleteOnExit(Boolean.parseBoolean( o.get("deleteOnExit").toString()));
    
    if (o.keySet().contains("descriptorDirectory"))
      leoServer.setDescriptorDirectory( o.get("descriptorDirectory").toString());
    
    if (o.keySet().contains("casPoolSize"))
      leoServer.setCasPoolSize(Integer.parseInt(o.get("casPoolSize").toString()));
    
    if (o.keySet().contains("CCTimeout"))
      leoServer.setCCTimeout(Integer.parseInt(o.get("CCTimeout").toString()));
    
    if (o.keySet().contains("jamQueryIntervalInSeconds"))
      leoServer.setJamQueryIntervalInSeconds(Integer.parseInt(o.get("jamQueryIntervalInSeconds").toString()));
    
    if (o.keySet().contains("jamResetStatisticsAfterQuery"))
      leoServer.setJamResetStatisticsAfterQuery(Boolean.parseBoolean( o.get("jamResetStatisticsAfterQuery").toString()));
    
    if (o.keySet().contains("jamServerBaseUrl"))
      leoServer.setJamServerBaseUrl( o.get("jamServerBaseUrl").toString());
    
    if (o.keySet().contains("instanceNumber"))
      numberOfInstances = Integer.parseInt(o.get("instanceNumber").toString());
    
    if (o.keySet().contains("isAsync"))
      isAsync = Boolean.parseBoolean(o.get("isAsync").toString());

    return leoServer;
  }


}

