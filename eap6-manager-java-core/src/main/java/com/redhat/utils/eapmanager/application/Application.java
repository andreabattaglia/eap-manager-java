/// **
// *
// */
// package com.redhat.utils.eapmanager.application;
//
// import org.jboss.resteasy.cdi.ResteasyCdiExtension;
// import org.jboss.resteasy.plugins.server.netty.cdi.CdiNettyJaxrsServer;
// import org.jboss.resteasy.spi.ResteasyDeployment;
// import org.jboss.weld.environment.se.Weld;
// import org.jboss.weld.environment.se.WeldContainer;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
//
/// **
// * @author Andrea Battaglia (Red Hat)
// *
// */
// public class Application {
// /**
// * Logger for this class
// */
// private static final Logger LOG = LoggerFactory.getLogger(Application.class);
//
// public static void main(String[] args) {
// new Application().startup();
// }
//
// public Application() {
// // TODO Auto-generated constructor stub
// }
//
// private Weld weld = null;
// private ShutdownHook shutdownHook;
// private WeldContainer container = null;
// private ResteasyCdiExtension resteasyCdiExtension = null;
// private CdiNettyJaxrsServer cdiNettyJaxrsServer = null;
// private ResteasyDeployment resteasyDeployment = null;
//
// public final void startup() {
// LOG.info("Initialization started...");
// weld = new Weld();
// // cdiNettyJaxrsServer = new CdiNettyJaxrsServer();
// shutdownHook = new ShutdownHook(weld
// // , cdiNettyJaxrsServer
// );
// Runtime.getRuntime().addShutdownHook(shutdownHook);
//
// LOG.info("Starting CDI container...");
// container = weld.initialize();
// LOG.info("CDI container started...");
// // resteasyCdiExtension =
// // CDI.current().select(ResteasyCdiExtension.class)
// // .get();
// // resteasyDeployment = new ResteasyDeployment();
// // resteasyDeployment.setActualResourceClasses(resteasyCdiExtension
// // .getResources());
// // resteasyDeployment.setInjectorFactoryClass(CdiInjectorFactory.class
// // .getName());
// // resteasyDeployment.getActualProviderClasses().addAll(
// // resteasyCdiExtension.getProviders());
// // cdiNettyJaxrsServer.setDeployment(resteasyDeployment);
// // cdiNettyJaxrsServer.setPort(7779);
// // cdiNettyJaxrsServer.setRootResourcePath("/dmc");
// // LOG.info("Starting REST server...");
// // cdiNettyJaxrsServer.start();
// // LOG.info("REST server started...");
//
// LOG.info("Initialization completed...");
// // EapManagerCLI eapManagerCLI =
// // CDI.current().select(EapManagerCLI.class).get();
// // eapManagerCLI.start();
// }
//
// /**
// * Shut down Weld immediately. Removes shutdown hook. Blocks until Weld is
// * completely shut down.
// */
// public void shutdownNow() {
// Runtime.getRuntime().removeShutdownHook(shutdownHook);
// shutdownHook.run();
// }
//
// static class ShutdownHook extends Thread {
// private static final Logger LOG =
/// LoggerFactory.getLogger(ShutdownHook.class);
//
// private final Weld weld;
// // private CdiNettyJaxrsServer cdiNettyJaxrsServer;
//
// ShutdownHook(Weld weld
// // , CdiNettyJaxrsServer cdiNettyJaxrsServer
// ) {
// this.weld = weld;
// // this.cdiNettyJaxrsServer = cdiNettyJaxrsServer;
// }
//
// @Override
// public void run() {
// LOG.info("Shutdown started...");
//
// // LOG.info("Stopping REST server...");
// // cdiNettyJaxrsServer.stop();
// // LOG.info("REST server stopped...");
//
// LOG.info("Stopping CDI container...");
// weld.shutdown();
// LOG.info("CDI container stopped...");
//
// LOG.info("Shutdown completed...");
// }
// }
// }
