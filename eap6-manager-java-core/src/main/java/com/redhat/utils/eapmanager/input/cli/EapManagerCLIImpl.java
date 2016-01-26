// package com.redhat.utils.eapmanager.input.cli;
//
// import java.io.BufferedReader;
// import java.io.Console;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.Map.Entry;
//
// import javax.enterprise.context.ApplicationScoped;
// import javax.inject.Inject;
//
// import org.slf4j.Logger;
//
// import com.redhat.utils.eapmanager.actions.ActionManager;
// import com.redhat.utils.eapmanager.constants.MessageConstants;
// import com.redhat.utils.eapmanager.input.EapManagerCLI;
// import com.redhat.utils.eapmanager.systemc.ApplicationScopedClass;
//
// @ApplicationScoped
// public class EapManagerCLIImpl  implements
// EapManagerCLI {
// @Inject
// private Logger LOG;
//
// @Inject
// private ActionManager actionsManagerImpl;
//
// private String actionsMenu;
//
// @Override
// protected void init() {
// StringBuilder sb = new StringBuilder();
// sb.append(MessageConstants.APPLICATION_NAME.getValue())//
// .append('\n')//
// .append('\n')//
// .append(MessageConstants.AVAILABLE_EAPMAN_ACTIONS)//
// .append('\n')//
// .append('\n');
// for (Entry<Short, String> entry :
// actionsManagerImpl.getActionsMap().entrySet()) {
// sb.append(entry.getKey())//
// .append(" - ")//
// .append(entry.getValue())//
// .append('\n');
// }
// sb.append("\nChoose your action: ");
// actionsMenu = sb.toString();
// }
//
// /* (non-Javadoc)
// * @see com.redhat.utils.eapmanager.input.cli.EapManagerCLI#start()
// */
// @Override
// public void start() {
// if (System.console() != null) {
// useConsole();
// } else {
// useReader();
// }
// }
//
// private void useConsole() {
// Console cons = System.console();
// while (true) {
// String value = cons.readLine(actionsMenu);
// try {
// Integer.parseInt(value);
// System.out.println("OK");
// } catch (NumberFormatException e) {
// System.out.println("NAN");
// }
// }
//
// }
//
// private void useReader() {
// BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
// while (true) {
// System.out.println(actionsMenu);
// String value;
// try {
// value = reader.readLine();
// try {
// Integer.parseInt(value);
// System.out.println("OK");
// } catch (NumberFormatException nfe) {
// System.out.println("NAN");
// }
// } catch (IOException ioe) {
// LOG.error(ioe.getMessage());
// }
// }
// }
// }
