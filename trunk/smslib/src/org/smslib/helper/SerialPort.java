// SMSLib for Java v3
// A Java API library for sending and receiving SMS via a GSM modem
// or other supported gateways.
// Web Site: http://www.smslib.org
//
// Copyright (C) 2002-2010, Thanasis Delenikas, Athens/GREECE.
// SMSLib is distributed under the terms of the Apache License version 2.0
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package org.smslib.helper;

import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * An RS-232 serial communications port.
 * <p>
 * <b>Please note: </b>This is a wrapper around
 * <code>javax.comm.SerialPort</code> (and so <code>gnu.io.SerialPort</code>).
 * The API definition is taken from Sun. So honor them!
 * </p>
 * <code>SerialPort</code> describes the low-level interface to a serial
 * communications port made available by the underlying system.
 * <code>SerialPort</code> defines the minimum required functionality for
 * serial communications ports.
 * 
 * @author gwellisch
 */
public class SerialPort
{
	/**
	 * Wrapper for SerialPortEventListeners
	 */
	private class SerialPortEventListenerHandler implements InvocationHandler
	{
		private SerialPortEventListener realListenerObject;

		public SerialPortEventListenerHandler(SerialPortEventListener realListenerObj)
		{
			this.realListenerObject = realListenerObj;
		}

		/**
		 * It's a simple interfaces. just call the only available method with
		 * the (only) given argument
		 */
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
		{
			this.realListenerObject.serialEvent(new SerialPortEvent(args[0]));
			// The original interfaces is void
			return null;
		}
	}

	static private Class<?> classSerialPort;

	/** RTS/CTS flow control on input. */
	public static final int FLOWCONTROL_RTSCTS_IN;

	/** 8 data bit format. */
	public static final int DATABITS_8;

	/** Number of STOP bits - 1. */
	public static final int STOPBITS_1;

	/** No parity bit. */
	public static final int PARITY_NONE;

	/** RTS/CTS flow control on output. */
	public static final int FLOWCONTROL_RTSCTS_OUT;
	static
	{
		try
		{
			classSerialPort = Class.forName("javax.comm.SerialPort");
		}
		catch (ClassNotFoundException e1)
		{
			try
			{
				classSerialPort = Class.forName("gnu.io.SerialPort");
			}
			catch (ClassNotFoundException e2)
			{
				throw new RuntimeException("SerialPort class not found");
			}
		}
		try
		{
			// get the value of constants
			Field f;
			f = classSerialPort.getField("FLOWCONTROL_RTSCTS_IN");
			FLOWCONTROL_RTSCTS_IN = f.getInt(null);
			f = classSerialPort.getField("DATABITS_8");
			DATABITS_8 = f.getInt(null);
			f = classSerialPort.getField("STOPBITS_1");
			STOPBITS_1 = f.getInt(null);
			f = classSerialPort.getField("PARITY_NONE");
			PARITY_NONE = f.getInt(null);
			f = classSerialPort.getField("FLOWCONTROL_RTSCTS_OUT");
			FLOWCONTROL_RTSCTS_OUT = f.getInt(null);
		}
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	private Object realObject;

	protected SerialPort(Object myRealObject)
	{
		this.realObject = myRealObject;
	}

	/**
	 * Registers a SerialPortEventListener object to listen for SerialEvents.
	 * Interest in specific events may be expressed using the notifyOnXXX calls.
	 * The serialEvent method of SerialPortEventListener will be called with a
	 * SerialEvent object describing the event. The current implementation only
	 * allows one listener per SerialPort. Once a listener is registered,
	 * subsequent call attempts to addEventListener will throw a
	 * TooManyListenersException without effecting the listener already
	 * registered. All the events received by this listener are generated by one
	 * dedicated thread that belongs to the SerialPort object. After the port is
	 * closed, no more event will be generated. Another call to open() of the
	 * port's CommPortIdentifier object will return a new CommPort object, and
	 * the lsnr has to be added again to the new CommPort object to receive
	 * event from this port.
	 * 
	 * @param lsnr
	 *            The SerialPortEventListener object whose serialEvent method
	 *            will be called with a SerialEvent describing the event.
	 * @throws java.util.TooManyListenersException
	 *             (Wrapped as RuntimeException) If an initial attempt to attach
	 *             a listener succeeds, subsequent attempts will throw
	 *             TooManyListenersException without effecting the first
	 *             listener.
	 */
	public void addEventListener(final SerialPortEventListener lsnr)
	{
		try
		{
			Method method = ReflectionHelper.getMethodOnlyByName(classSerialPort, "addEventListener");
			// Determine the exact interface argument type (javax.comm.SerialPortEventListener or gnu.io.SerialPortEventListener)
			Class<?> eventI = method.getParameterTypes()[0];
			InvocationHandler handler = new SerialPortEventListenerHandler(lsnr);
			// Create proxy class on the found interface type
			Class<?> proxyClass = Proxy.getProxyClass(eventI.getClassLoader(), eventI);
			// Bind our proxy object to the original addListener
			method.invoke(this.realObject, proxyClass.getConstructor(InvocationHandler.class).newInstance(handler));
		}
		catch (InvocationTargetException e)
		{
			throw new RuntimeException(new RuntimeException(e.getTargetException().toString()));
		}
		catch (Exception e) // Catching exception isn't nice, but sufficient here.
		{
			throw new RuntimeException(e);
		}
	}

	/**
	 * Closes the communications port. The application must call
	 * <code>close</code> when it is done with the port. Notification of this
	 * ownership change will be propagated to all classes registered using
	 * <code>addPortOwnershipListener</code>.
	 */
	public void close()
	{
		try
		{
			Method method = classSerialPort.getMethod("close", (java.lang.Class[]) null);
			method.invoke(this.realObject);
		}
		catch (InvocationTargetException e)
		{
			throw new RuntimeException(new RuntimeException(e.getTargetException().toString()));
		}
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	/**
	 * Enables receive threshold, if this feature is supported by the driver.
	 * When the receive threshold condition becomes true, a read from the input
	 * stream for this port will return immediately. enableReceiveThreshold is
	 * an advisory method which the driver may not implement. By default,
	 * receive threshold is not enabled. An application can determine whether
	 * the driver supports this feature by first calling the
	 * enableReceiveThreshold method and then calling the
	 * isReceiveThresholdEnabled method. If isReceiveThresholdEnabled still
	 * returns false, then receive threshold is not supported by the driver. If
	 * the driver does not implement this feature, it will return from blocking
	 * reads at an appropriate time. See getInputStream for description of exact
	 * behaviour.
	 * 
	 * @param i
	 *            when this many bytes are in the input buffer, return
	 *            immediately from read.
	 * @throws UnsupportedCommOperationException -
	 *             (Wrapped as RuntimeException) is thrown if receive threshold
	 *             is not supported by the underlying driver.
	 */
	public void enableReceiveThreshold(int i)
	{
		try
		{
			Method method = classSerialPort.getMethod("enableReceiveThreshold", int.class);
			method.invoke(this.realObject, i);
		}
		catch (InvocationTargetException e)
		{
			throw new RuntimeException(new RuntimeException(e.getTargetException().toString()));
		}
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	/**
	 * Enables receive timeout, if this feature is supported by the driver. When
	 * the receive timeout condition becomes true, a <code>read</code> from
	 * the input stream for this port will return immediately.
	 * <p>
	 * <code>enableReceiveTimeout</code> is an advisory method which the
	 * driver may not implement. By default, receive timeout is not enabled.
	 * </p>
	 * <p>
	 * An application can determine whether the driver supports this feature by
	 * first calling the <code>enableReceiveTimeout</code> method and then
	 * calling the <code>isReceiveTimeout</code> method. If
	 * <code>isReceiveTimeout</code> still returns false, then receive timeout
	 * is not supported by the driver.
	 * </p>
	 * <p>
	 * See <code>getInputStream</code> for description of exact behaviour.
	 * </p>
	 * 
	 * @param rcvTimeout
	 *            when this many milliseconds have elapsed, return immediately
	 *            from read, regardless of bytes in input buffer.
	 */
	public void enableReceiveTimeout(int rcvTimeout)
	{
		Class<?>[] paramTypes = new Class<?>[] { int.class };
		try
		{
			Method method = classSerialPort.getMethod("enableReceiveTimeout", paramTypes);
			method.invoke(this.realObject, rcvTimeout);
		}
		catch (InvocationTargetException e)
		{
			throw new RuntimeException(new RuntimeException(e.getTargetException().toString()));
		}
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	/**
	 * Returns an input stream. This is the only way to receive data from the
	 * communications port. If the port is unidirectional and doesn't support
	 * receiving data, then <CODE>getInputStream</CODE> returns null.
	 * <P>
	 * The read behaviour of the input stream returned by
	 * <CODE>getInputStream</CODE> depends on combination of the threshold and
	 * timeout values. The possible behaviours are described in the table below:
	 * <P>
	 * <table border="1">
	 * <tr>
	 * <th colspan=2>Threshold</th>
	 * <th colspan=2>Timeout</th>
	 * <th rowspan=2>Read Buffer Size</th>
	 * <th rowspan=2>Read Behaviour</th>
	 * </tr>
	 * <tr>
	 * <th>State</th>
	 * <th>Value</th>
	 * <th>State</th>
	 * <th>Value</th>
	 * </tr>
	 * <tr>
	 * <td> disabled </td>
	 * <td> - </td>
	 * <td> disabled </td>
	 * <td> - </td>
	 * <td> n bytes </td>
	 * <td> block until any data is available </td>
	 * </tr>
	 * <tr>
	 * <td> enabled </td>
	 * <td> m bytes </td>
	 * <td> disabled </td>
	 * <td> - </td>
	 * <td> n bytes </td>
	 * <td> block until min(<I>m</I>,<I>n</I>) bytes are available </td>
	 * </tr>
	 * <tr>
	 * <td> disabled </td>
	 * <td> - </td>
	 * <td> enabled </td>
	 * <td> x ms </td>
	 * <td> n bytes </td>
	 * <td> block for <I>x</I> ms or until any data is available </td>
	 * </tr>
	 * <tr>
	 * <td> enabled </td>
	 * <td> m bytes </td>
	 * <td> enabled </td>
	 * <td> x ms </td>
	 * <td> n bytes </td>
	 * <td> block for <I>x</I> ms or until min(<I>m</I>,<I>n</I>) bytes are
	 * available </td>
	 * </tr>
	 * </table>
	 * <P>
	 * Note, however, that framing errors may cause the Timeout and Threshold
	 * values to complete prematurely without raising an exception.
	 * <P>
	 * Enabling the Timeout OR Threshold with a value a zero is a special case.
	 * This causes the underlying driver to poll for incoming data instead being
	 * event driven. Otherwise, the behaviour is identical to having both the
	 * Timeout and Threshold disabled.
	 * 
	 * @return InputStream object that can be used to read from the port
	 */
	public InputStream getInputStream()
	{
		try
		{
			Method method = classSerialPort.getMethod("getInputStream", (java.lang.Class[]) null);
			return (InputStream) method.invoke(this.realObject);
		}
		catch (InvocationTargetException e)
		{
			throw new RuntimeException(new RuntimeException(e.getTargetException().toString()));
		}
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	/**
	 * Returns an output stream. This is the only way to send data to the
	 * communications port. If the port is unidirectional and doesn't support
	 * sending data, then getOutputStream returns null.
	 * 
	 * @return OutputStream object that can be used to write to the port
	 */
	public OutputStream getOutputStream()
	{
		try
		{
			Method method = classSerialPort.getMethod("getOutputStream", (java.lang.Class[]) null);
			return (OutputStream) method.invoke(this.realObject);
		}
		catch (InvocationTargetException e)
		{
			throw new RuntimeException(new RuntimeException(e.getTargetException().toString()));
		}
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	/**
	 * Expresses interest in receiving notification when there is a break
	 * interrupt on the line. This notification is hardware dependent and may
	 * not be supported by all implementations.
	 * 
	 * @param b
	 *            <ul>
	 *            <li> true: enable notification </li>
	 *            <li> false: disable notification </li>
	 */
	public void notifyOnBreakInterrupt(boolean b)
	{
		try
		{
			Method method = classSerialPort.getMethod("notifyOnBreakInterrupt", boolean.class);
			method.invoke(this.realObject, b);
		}
		catch (InvocationTargetException e)
		{
			throw new RuntimeException(new RuntimeException(e.getTargetException().toString()));
		}
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	/**
	 * Expresses interest in receiving notification when input data is
	 * available. This may be used to drive asynchronous input. When data is
	 * available in the input buffer, this event is propagated to the listener
	 * registered using addEventListener. The event will be generated once when
	 * new data arrive at the serial port. Even if the user doesn't read the
	 * data, it won't be generated again until next time new data arrive.
	 * 
	 * @param b
	 *            <ul>
	 *            <li> true: enable notification </li>
	 *            <li> false: disable notification </li>
	 */
	public void notifyOnDataAvailable(boolean b)
	{
		try
		{
			Method method = classSerialPort.getMethod("notifyOnDataAvailable", boolean.class);
			method.invoke(this.realObject, b);
		}
		catch (InvocationTargetException e)
		{
			throw new RuntimeException(new RuntimeException(e.getTargetException().toString()));
		}
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	/**
	 * Expresses interest in receiving notification when there is a parity
	 * error. This notification is hardware dependent and may not be supported
	 * by all implementations.
	 * 
	 * @param b
	 *            <ul>
	 *            <li> true: enable notification </li>
	 *            <li> false: disable notification </li>
	 */
	public void notifyOnFramingError(boolean b)
	{
		try
		{
			Method method = classSerialPort.getMethod("notifyOnFramingError", boolean.class);
			method.invoke(this.realObject, b);
		}
		catch (InvocationTargetException e)
		{
			throw new RuntimeException(new RuntimeException(e.getTargetException().toString()));
		}
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	/**
	 * Expresses interest in receiving notification when the output buffer is
	 * empty. This may be used to drive asynchronous output. When the output
	 * buffer becomes empty, this event is propagated to the listener registered
	 * using addEventListener. The event will be generated after a write is
	 * completed, when the system buffer becomes empty again. This notification
	 * is hardware dependent and may not be supported by all implementations.
	 * 
	 * @param b
	 *            <ul>
	 *            <li> true: enable notification </li>
	 *            <li> false: disable notification </li>
	 */
	public void notifyOnOutputEmpty(boolean b)
	{
		try
		{
			Method method = classSerialPort.getMethod("notifyOnOutputEmpty", boolean.class);
			method.invoke(this.realObject, b);
		}
		catch (InvocationTargetException e)
		{
			throw new RuntimeException(new RuntimeException(e.getTargetException().toString()));
		}
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	/**
	 * Expresses interest in receiving notification when there is an overrun
	 * error. This notification is hardware dependent and may not be supported
	 * by all implementations.
	 * 
	 * @param b
	 *            <ul>
	 *            <li> true: enable notification </li>
	 *            <li> false: disable notification </li>
	 */
	public void notifyOnOverrunError(boolean b)
	{
		try
		{
			Method method = classSerialPort.getMethod("notifyOnOverrunError", boolean.class);
			method.invoke(this.realObject, b);
		}
		catch (InvocationTargetException e)
		{
			throw new RuntimeException(new RuntimeException(e.getTargetException().toString()));
		}
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	/**
	 * Expresses interest in receiving notification when there is a parity
	 * error. This notification is hardware dependent and may not be supported
	 * by all implementations.
	 * 
	 * @param b
	 *            <ul>
	 *            <li> true: enable notification </li>
	 *            <li> false: disable notification </li>
	 */
	public void notifyOnParityError(boolean b)
	{
		try
		{
			Method method = classSerialPort.getMethod("notifyOnParityError", boolean.class);
			method.invoke(this.realObject, b);
		}
		catch (InvocationTargetException e)
		{
			throw new RuntimeException(new RuntimeException(e.getTargetException().toString()));
		}
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	/**
	 * Sets the flow control mode.
	 * 
	 * @param flowcontrol
	 *            Can be a bitmask combination of
	 *            <ul>
	 *            <li>FLOWCONTROL_NONE: no flow control</li>
	 *            <li>FLOWCONTROL_RTSCTS_IN: RTS/CTS (hardware) flow control
	 *            for input</li>
	 *            <li>FLOWCONTROL_RTSCTS_OUT: RTS/CTS (hardware) flow control
	 *            for output</li>
	 *            <li>FLOWCONTROL_XONXOFF_IN: XON/XOFF (software) flow control
	 *            for input</li>
	 *            <li>FLOWCONTROL_XONXOFF_OUT: XON/XOFF (software) flow control
	 *            for output</li>
	 *            </ul>
	 */
	public void setFlowControlMode(int flowcontrol)
	{
		Class<?>[] paramTypes = new Class<?>[] { int.class };
		try
		{
			Method method = classSerialPort.getMethod("setFlowControlMode", paramTypes);
			method.invoke(this.realObject, flowcontrol);
		}
		catch (InvocationTargetException e)
		{
			throw new RuntimeException(new RuntimeException(e.getTargetException().toString()));
		}
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	/**
	 * Gets the input buffer size. Note that this method is advisory and the
	 * underlying OS may choose not to report correct values for the buffer
	 * size.
	 * 
	 * @param serial_buffer_size
	 *            input buffer size currently in use
	 */
	public void setInputBufferSize(int serial_buffer_size)
	{
		try
		{
			Method method = classSerialPort.getMethod("setInputBufferSize", int.class);
			method.invoke(this.realObject, serial_buffer_size);
		}
		catch (InvocationTargetException e)
		{
			throw new RuntimeException(new RuntimeException(e.getTargetException().toString()));
		}
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	/**
	 * Sets the output buffer size. Note that this is advisory and memory
	 * availability may determine the ultimate buffer size used by the driver.
	 * 
	 * @param serial_buffer_size
	 *            size of the output buffer
	 */
	public void setOutputBufferSize(int serial_buffer_size)
	{
		try
		{
			Method method = classSerialPort.getMethod("setOutputBufferSize", int.class);
			method.invoke(this.realObject, serial_buffer_size);
		}
		catch (InvocationTargetException e)
		{
			throw new RuntimeException(new RuntimeException(e.getTargetException().toString()));
		}
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	/**
	 * Sets serial port parameters.
	 * 
	 * @param baudrate
	 *            If the baudrate passed in by the application is unsupported by
	 *            the driver, the driver will throw an
	 *            UnsupportedCommOperationException
	 * @param dataBits
	 *            <ul>
	 *            <li>DATABITS_5: 5 bits</li>
	 *            <li>DATABITS_6: 6 bits</li>
	 *            <li>DATABITS_7: 7 bits</li>
	 *            <li>DATABITS_8: 8 bits</li>
	 *            </ul>
	 * @param stopBits
	 *            <ul>
	 *            <li>STOPBITS_1: 1 stop bit</li>
	 *            <li>STOPBITS_2: 2 stop bits</li>
	 *            <li>STOPBITS_1_5: 1.5 stop bits</li>
	 *            </ul>
	 * @param parity
	 *            <ul>
	 *            <li>PARITY_NONE: no parity PARITY_ODD: odd parity</li>
	 *            <li>PARITY_EVEN: even parity PARITY_MARK: mark parity</li>
	 *            <li>PARITY_SPACE: space parity</li>
	 *            </ul>
	 */
	public void setSerialPortParams(int baudrate, int dataBits, int stopBits, int parity)
	{
		Class<?>[] paramTypes = new Class<?>[] { int.class, int.class, int.class, int.class };
		try
		{
			Method method = classSerialPort.getMethod("setSerialPortParams", paramTypes);
			method.invoke(this.realObject, baudrate, dataBits, stopBits, parity);
		}
		catch (InvocationTargetException e)
		{
			throw new RuntimeException(new RuntimeException(e.getTargetException().toString()));
		}
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}
}
