package Flexport;


//468
//Input: IP = "172.16.254.1"
//Output: "IPv4"
//Explanation: This is a valid IPv4 address, return "IPv4".
public class Vallidation_IP_Address {
    String bad = "Neither";
    public String validIPAddress(String IP) {

        if(IP == null || IP.length() == 0) return bad;
        //IP = IP.trim();
        if(isIPv4(IP)){
            return "IPv4";
        }

        else if(isIPv6(IP))
            return "IPv6";

        return bad;
    }

    //ipv4
    boolean isIPv4(String IP){
        if(IP.charAt(IP.length()-1) == '.') return false;
        String[] parts = IP.split("\\.");
        if(parts.length != 4) return false;

        for(String p: parts){
            if(!checkIPv4(p)) return false;
        }

        return true;
    }

    //check ipv4

    boolean checkIPv4(String p){
        if(p == null || p.length() == 0) return false;

        if(p.charAt(0) == '0' && p.length() > 1) return false;
        try{

            int n = Integer.parseInt(p);
            if(n < 0 || n > 255) return false;

            if(n == 0 && p.length() > 1) return false;
        }
        catch(NumberFormatException e){
            return false;
        }
        return true;
    }


    //ipv6
    boolean isIPv6(String IP){
        if(IP.charAt(IP.length()-1) == ':') return false;

        String[] parts =IP.split(":");
        if(parts.length != 8) return false;

        for(String p: parts){
            if(!checkIPv6(p)) return false;
        }

        return true;
    }

    boolean checkIPv6(String part){
        if(part.length() == 0 || part.length() > 4){
            return false;
        }

        for(char c : part.toCharArray()){

            boolean isUpper = c>='A' && c<='F';
            boolean isLower = c>='a' && c<='f';
            if(c>='0' && c<='9') continue;
            else if(c>='A' && c<='F') continue;
            else if(c>='a' && c<='f') continue;
            else return false;
        }
        return true;
    }
}
