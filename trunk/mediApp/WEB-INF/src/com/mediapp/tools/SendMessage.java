// SendMessage.java - Sample application.
//
// This application shows you the basic procedure for sending messages.
// You will find how to send synchronous and asynchronous messages.
//
// For asynchronous dispatch, the example application sets a callback
// notification, to see what's happened with messages.

package com.mediapp.tools;

import java.util.ArrayList;
import java.util.List;

import org.smslib.AGateway;
import org.smslib.Group;
import org.smslib.IOutboundMessageNotification;
import org.smslib.Library;
import org.smslib.OutboundMessage;
import org.smslib.Service;
import org.smslib.modem.SerialModemGateway;

public class SendMessage
{
	public void doIt() throws Exception
	{
		Service srv;
		OutboundMessage msg;
		OutboundNotification outboundNotification = new OutboundNotification();
		System.out.println("Example: Send message from a serial gsm modem.");
		System.out.println(Library.getLibraryDescription());
		System.out.println("Version: " + Library.getLibraryVersion());
		srv = new Service();
		SerialModemGateway gateway = new SerialModemGateway("modem.com1", "COM1", 9600, "SIMCOM_SIM300", "300");		
		gateway.setInbound(true);
		gateway.setOutbound(true);
		gateway.setSimPin("0000");
		srv.setOutboundMessageNotification(outboundNotification);
		srv.addGateway(gateway);
		srv.startService();
		System.out.println();
		System.out.println("Modem Information:");
		System.out.println("  Manufacturer: " + gateway.getManufacturer());
		System.out.println("  Model: " + gateway.getModel());
		System.out.println("  Serial No: " + gateway.getSerialNo());
		System.out.println("  SIM IMSI: " + gateway.getImsi());
		System.out.println("  Signal Level: " + gateway.getSignalLevel() + "%");
		System.out.println("  Battery Level: " + gateway.getBatteryLevel() + "%");
		System.out.println();
		// Send a message synchronously.
		srv.createGroup("TestGroup");
		srv.addToGroup("TestGroup", "+919538885476");
		msg = new OutboundMessage("TestGroup", "Hello from MediApp!");
//		msg = new OutboundMessage("+919538885476", "Hello from MediApp!");
		srv.sendMessage(msg);
		System.out.println(msg);
		// Or, send out a WAP SI message.
		//OutboundWapSIMessage wapMsg = new OutboundWapSIMessage("+306948494037",  new URL("https://mail.google.com/"), "Visit GMail now!");
		//srv.sendMessage(wapMsg);
		//System.out.println(wapMsg);
		// You can also queue some asynchronous messages to see how the callbacks
		// are called...
		//msg = new OutboundMessage("+309999999999", "Wrong number!");
		//srv.queueMessage(msg, gateway.getGatewayId());
		//msg = new OutboundMessage("+308888888888", "Wrong number!");
		//srv.queueMessage(msg, gateway.getGatewayId());
		System.out.println("Now Sleeping - Hit <enter> to terminate.");
		System.in.read();
		srv.stopService();
	}

	public class OutboundNotification implements IOutboundMessageNotification
	{
		public void process(AGateway gateway, OutboundMessage msg)
		{
			System.out.println("Outbound handler called from Gateway: " + gateway.getGatewayId());
			System.out.println(msg);
		}
	}

	public static void main(String args[])
	{
		SendMessage app = new SendMessage();
		try
		{
			app.doIt();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
