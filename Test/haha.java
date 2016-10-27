package network;

import jpcap.JpcapCaptor;
import jpcap.JpcapWriter;
import jpcap.NetworkInterface;
import jpcap.NetworkInterfaceAddress;
import jpcap.packet.DatalinkPacket;
import jpcap.packet.EthernetPacket;
import jpcap.packet.IPPacket;
import java.io.IOException;
import java.io.SyncFailedException;

/**
 * Created by 14777 on 2016/10/26.
 */
public class NetTest {
    public static void main(String[]args) throws IllegalAccessException, InstantiationException {
        String s="8980";
        Class c=s.getClass();
        String t=(String)c.newInstance();



        NetworkInterface []devices=JpcapCaptor.getDeviceList();


        for(int i=0;i<devices.length;i++){
            System.out.println("momomommommmoomommomomomomom "+i);
            System.out.println("网卡名称 "+devices[i].name);
            System.out.println("网卡的描述 "+devices[i].description);
            System.out.println("数据链路层描述（如所在的局域网是什么网) "+devices[i].datalink_description);
            System.out.println("网卡所连接的数据链路名称（eth10m 100m) "+devices[i].datalink_name);

            System.out.print("Mac 地址 ");
            for(Byte b:devices[i].mac_address){
                System.out.print(Integer.toHexString(b&0xff)+":");
            }
            System.out.println();
            for(Byte b:devices[i].mac_address){

                System.out.print((Integer.parseInt(b.toString(),10)+256)%256+":");
            }
            System.out.println();
            System.out.println("接口的网络地址 （ipv4 ipv6 等");
            for(NetworkInterfaceAddress a:devices[i].addresses){
                System.out.println(a.address+" "+a.subnet+" "+a.broadcast+" "+a.destination);
            }
        }

        System.out.println("以上是我的电脑的网卡的信息");




        try{

            JpcapCaptor captor=JpcapCaptor.openDevice(devices[1],65535,false,20000);
            captor.setFilter("ip and tcp",true);
            JpcapWriter jpcapWriter=null;
            try {
                jpcapWriter=JpcapWriter.openDumpFile(captor,"d://capt.data");
            } catch (IOException e) {
                e.printStackTrace();
            }


            JpcapWriter finalJpcapWriter = jpcapWriter;

            captor.processPacket(2,(packet)->{
                StringBuffer sb=new StringBuffer("");

                //物理层
                sb.append("------包分析-------\n");
                sb.append("Captured Length:"+packet.caplen+" byte\n");
                sb.append("Length of this Packet:"+packet.len+" byte\n");
                sb.append("Header:"+packet.header+"\n");
                sb.append("Length of Header:"+packet.header.length+" byte\n");
                sb.append("Data:"+packet.data+"\n");
                sb.append("Length of Data:"+packet.data.length+" byte\n");
                sb.append("---Ethernet头部信息---\n");

                //数据链路层
                DatalinkPacket dPacket = packet.datalink;
                if(dPacket instanceof EthernetPacket){
                    EthernetPacket ePacket = (EthernetPacket)dPacket;
                    sb.append("src_mac:");
                    int flag1 = 0;
                    for(byte b:ePacket.src_mac){
                        flag1++;
                        if(flag1<ePacket.src_mac.length){
                            sb.append(Integer.toHexString(b & 0xff)+":");
                        }else
                            sb.append(Integer.toHexString(b & 0xff)+"\n");
                    }

                    sb.append("dst_mac:");
                    int flag2 = 0;
                    for(byte b:ePacket.dst_mac){
                        flag2++;
                        if(flag2<ePacket.dst_mac.length){
                            sb.append(Integer.toHexString(b & 0xff)+":");
                        }else
                            sb.append(Integer.toHexString(b & 0xff)+"\nn");

                    }

                    sb.append("frametype:"+Integer.toHexString(ePacket.frametype & 0xffff)+"\n");
                    sb.append("------------------\n");
                }else{
                    sb.append(dPacket+"\n");
                    sb.append("------------------\n");
                }

                if(packet instanceof IPPacket){        //分析IP
                    IPPacket iPacket = (IPPacket)packet;
                    sb.append("---IP版本: "+iPacket.version+" ---\n");
                    if(iPacket.version==4){                //分析IPv4协议
                        sb.append("Type of service:"+iPacket.rsv_tos+"\n");
                        sb.append("Priprity:"+iPacket.priority+"\n");
                        sb.append("Packet Length:"+iPacket.length+"\n");
                        sb.append("Identification:"+iPacket.ident+"\n");
                        sb.append("Don't Frag? "+iPacket.dont_frag+"\n");
                        sb.append("More Frag? "+iPacket.more_frag+"\n");
                        sb.append("Frag Offset:"+iPacket.offset+"\n");
                        sb.append("Time to Live:"+iPacket.hop_limit+"\n");
                        sb.append("Protocol:"+iPacket.protocol+"        (TCP = 6; UDP = 17)\n");
                        sb.append("Source address:"+iPacket.src_ip.toString()+"\n");
                        sb.append("Destination address:"+iPacket.dst_ip.toString()+"\n");
                        sb.append("Options:"+iPacket.option+"\n");
                        sb.append("------------------\n");
                    }
                }
                System.out.println(sb);


            });
        }catch (Exception e){
            System.out.println("error");
            e.printStackTrace();
        }
        
    }

}