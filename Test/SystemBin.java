import java.util.*;
import jpcap.JpcapCaptor;
import jpcap.NetworkInterface;
public class SystemBin{
	public static void main(String[]args){
		NetworkInterface []devices=JpcapCaptor.getDeviceList();
		System.out.println(devices.length);
	}
}