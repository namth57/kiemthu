package oop.asg02;
import java.io.*;
public class BigInteger
{
    private String BigInt;
    public BigInteger(int init) {
        BigInt = String.valueOf(init);
    }

    public BigInteger(Long init) {
        BigInt = String.valueOf(init);
    }

    public BigInteger(String init) {
        int i=0;
        char temp=init.charAt(i);
        while ((temp =='0')&&(i<init.length()-1)){
            i++;
            temp=init.charAt(i);
        }
        BigInt = init.substring(i);
    }

    public String toString() {

        return BigInt;
    }

    public boolean equals(Object other) {
        return toString().equals(other.toString());
    }

    public long toLong() {
        return Long.parseLong(BigInt);
    }

    public BigInteger add(BigInteger other) {
        String str1= new String();
        String str2= new String();
        String str3= new String("0");
        int i,t,mod;
        int carry=0;
        while (BigInt.length()!= other.BigInt.length()){
            if (BigInt.length() > other.BigInt.length()){
                other.BigInt= str3.concat(other.BigInt);
            }
            else BigInt = str3.concat(BigInt);
        }
        other.BigInt= str3.concat(other.BigInt);
        BigInt = str3.concat(BigInt);
        for (i=BigInt.length()-1;i>=0;i--){
            char temp1[] = {BigInt.charAt(i)};
            char temp2[] = {other.BigInt.charAt(i)};
            String t1= new String(temp1);
            String t2= new String(temp2);
            t = Integer.valueOf(t1)+Integer.valueOf(t2)+carry;
            carry = t/10;
            mod = t%10;
            str1 = String.valueOf(mod);
            str2 = str1 + str2;
        }
        BigInteger b = new BigInteger(str2);
        return b;
    }

    public BigInteger subtract(BigInteger other) {
        String str1= new String();
        String str2= new String();
        String str3= new String("0");
        int i,t;
        int carry=0;
        while (BigInt.length()!= other.BigInt.length()){
            if (BigInt.length() > other.BigInt.length()){
                other.BigInt= str3.concat(other.BigInt);
            }
            else BigInt = str3.concat(BigInt);
        }
        other.BigInt= str3.concat(other.BigInt);
        BigInt = str3.concat(BigInt);
        for (i=BigInt.length()-1;i>=0;i--){
            char temp1[] = {BigInt.charAt(i)};
            char temp2[] = {other.BigInt.charAt(i)};
            String t1= new String(temp1);
            String t2= new String(temp2);
            t = Integer.valueOf(t1)-Integer.valueOf(t2) - carry;
            if (t<0 ) {
                carry = 1;
                t+=10;
            }
            else carry = 0;
            str1 = String.valueOf(t);
            str2 = str1 + str2;
        }
        BigInteger b = new BigInteger(str2);
        return b;
    }

    public int compareTo(BigInteger other){
        if (other.BigInt.length() < BigInt.length()) return 1;
        if (other.BigInt.length() > BigInt.length()) return -1;
        if (other.BigInt.length() == BigInt.length()){
            int i=0;
            while (i< BigInt.length()){
                char temp1[] = {BigInt.charAt(i)};
                char temp2[] = {other.BigInt.charAt(i)};
                String t1= new String(temp1);
                String t2= new String(temp2);
                if (Integer.valueOf(t1) < Integer.valueOf(t2)) return -1;
                if (Integer.valueOf(t1) > Integer.valueOf(t2)) return 1;
                i++;
            }
        }
        return 0;
    }

    public BigInteger clone(){
        BigInteger bigInt = new BigInteger(BigInt);
        return bigInt;
    }
    
      
}
