package org.edge.woostore.utils.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

public class VerifyCodeUtil {
	/** 
     * ��֤������Ϊ������,��0~9 
     */  
    public static final int TYPE_NUM_ONLY = 0;  
  
    /** 
     * ��֤������Ϊ����ĸ,����Сд��ĸ��� 
     */  
    public static final int TYPE_LETTER_ONLY = 1;  
  
    /** 
     * ��֤������Ϊ���ֺʹ�Сд��ĸ��� 
     */  
    public static final int TYPE_ALL_MIXED = 2;  
  
    /** 
     * ��֤������Ϊ���ֺʹ�д��ĸ��� 
     */  
    public static final int TYPE_NUM_UPPER = 3;  
  
    /** 
     * ��֤������Ϊ���ֺ�Сд��ĸ��� 
     */  
    public static final int TYPE_NUM_LOWER = 4;  
  
    /** 
     * ��֤������Ϊ����д��ĸ 
     */  
    public static final int TYPE_UPPER_ONLY = 5;  
  
    /** 
     * ��֤������Ϊ��Сд��ĸ 
     */  
    public static final int TYPE_LOWER_ONLY = 6;  
  
    private VerifyCodeUtil(){}  
      
    /** 
     * ��������ɫ 
     */  
    private static Color generateRandomColor() {  
        Random random = new Random();  
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));  
    }  
      
      
    /** 
     * ���ͼƬ��֤�� 
     * @param type           ��֤������,�μ���ľ�̬���� 
     * @param length         ��֤���ַ��,Ҫ�����0������ 
     * @param excludeString  ���ų�������ַ� 
     * @param width          ͼƬ���(ע��˿������С,���������֤���ı���ʾ��ȫ,��4���ַ���ı���ʹ��85��90�Ŀ��) 
     * @param height         ͼƬ�߶� 
     * @param interLine      ͼƬ�и����ߵ����� 
     * @param randomLocation ÿ���ַ�ĸߵ�λ���Ƿ���� 
     * @param backColor      ͼƬ��ɫ,��Ϊnull���ʾ���������ɫ 
     * @param foreColor      ������ɫ,��Ϊnull���ʾ���������ɫ 
     * @param lineColor      ��������ɫ,��Ϊnull���ʾ���������ɫ 
     * @return ͼƬ������� 
     */  
    public static BufferedImage generateImageCode(int type, int length, String excludeString, int width, int height, int interLine, boolean randomLocation, Color backColor, Color foreColor, Color lineColor){  
        String textCode = generateTextCode(type, length, excludeString);  
        return generateImageCode(textCode, width, height, interLine, randomLocation, backColor, foreColor, lineColor);  
    }  
      
  
    /** 
     * �����֤���ַ� 
     * @param type          ��֤������,�μ���ľ�̬���� 
     * @param length        ��֤�볤��,Ҫ�����0������ 
     * @param excludeString ���ų�������ַ������ų���Ϊnull�� 
     * @return ��֤���ַ� 
     */  
    public static String generateTextCode(int type, int length, String excludeString){  
        if(length <= 0){  
            return "";  
        }  
        StringBuffer verifyCode = new StringBuffer();  
        int i = 0;  
        Random random = new Random();  
        switch(type){  
            case TYPE_NUM_ONLY:  
                while(i < length){  
                    int t = random.nextInt(10);  
                    //�ų������ַ�  
                    if(null==excludeString || excludeString.indexOf(t+"")<0) {  
                        verifyCode.append(t);  
                        i++;  
                    }  
                }  
            break;  
            case TYPE_LETTER_ONLY:  
                while(i < length){  
                    int t = random.nextInt(123);  
                    if((t>=97 || (t>=65&&t<=90)) && (null==excludeString||excludeString.indexOf((char)t)<0)){  
                        verifyCode.append((char)t);  
                        i++;  
                    }  
                }  
            break;  
            case TYPE_ALL_MIXED:  
                while(i < length){  
                    int t = random.nextInt(123);  
                    if((t>=97 || (t>=65&&t<=90) || (t>=48&&t<=57)) && (null==excludeString||excludeString.indexOf((char)t)<0)){  
                        verifyCode.append((char)t);  
                        i++;  
                    }  
                }  
            break;  
            case TYPE_NUM_UPPER:  
                while(i < length){  
                    int t = random.nextInt(91);  
                    if((t>=65 || (t>=48&&t<=57)) && (null==excludeString || excludeString.indexOf((char)t)<0)){  
                        verifyCode.append((char)t);  
                        i++;  
                    }  
                }  
            break;  
            case TYPE_NUM_LOWER:  
                while(i < length){  
                    int t = random.nextInt(123);  
                    if((t>=97 || (t>=48&&t<=57)) && (null==excludeString || excludeString.indexOf((char)t)<0)){  
                        verifyCode.append((char)t);  
                        i++;  
                    }  
                }  
            break;  
            case TYPE_UPPER_ONLY:  
                while(i < length){  
                    int t = random.nextInt(91);  
                    if((t >= 65) && (null==excludeString||excludeString.indexOf((char)t)<0)){  
                        verifyCode.append((char)t);  
                        i++;  
                    }  
                }  
            break;  
            case TYPE_LOWER_ONLY:  
                while(i < length){  
                    int t = random.nextInt(123);  
                    if((t>=97) && (null==excludeString||excludeString.indexOf((char)t)<0)){  
                        verifyCode.append((char)t);  
                        i++;  
                    }  
                }  
            break;  
        }  
        return verifyCode.toString();  
    }  
  
    /** 
     * ������֤��,�����֤��ͼƬ 
     * @param textCode       �ı���֤�� 
     * @param width          ͼƬ���(ע��˿������С,���������֤���ı���ʾ��ȫ,��4���ַ���ı���ʹ��85��90�Ŀ��) 
     * @param height         ͼƬ�߶� 
     * @param interLine      ͼƬ�и����ߵ����� 
     * @param randomLocation ÿ���ַ�ĸߵ�λ���Ƿ���� 
     * @param backColor      ͼƬ��ɫ,��Ϊnull���ʾ���������ɫ 
     * @param foreColor      ������ɫ,��Ϊnull���ʾ���������ɫ 
     * @param lineColor      ��������ɫ,��Ϊnull���ʾ���������ɫ 
     * @return ͼƬ������� 
     */  
    public static BufferedImage generateImageCode(String textCode, int width, int height, int interLine, boolean randomLocation, Color backColor, Color foreColor, Color lineColor){  
        //�����ڴ�ͼ��  
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);  
        //��ȡͼ��������  
        Graphics graphics = bufferedImage.getGraphics();  
        //������ͼ  
        graphics.setColor(null==backColor ? generateRandomColor() : backColor);  
        graphics.fillRect(0, 0, width, height);  
        //��������  
        Random random = new Random();  
        if(interLine > 0){  
            int x = 0, y = 0, x1 = width, y1 = 0;  
            for(int i=0; i<interLine; i++){  
                graphics.setColor(null==lineColor ? generateRandomColor() : lineColor);  
                y = random.nextInt(height);  
                y1 = random.nextInt(height);  
                graphics.drawLine(x, y, x1, y1);  
            }  
        }  
        //�����СΪͼƬ�߶ȵ�80%  
        int fsize = (int)(height * 0.8);  
        int fx = height - fsize;  
        int fy = fsize;  
        //�趨����  
        graphics.setFont(new Font("Default", Font.PLAIN, fsize));  
        //д��֤���ַ�  
        for(int i=0; i<textCode.length(); i++){  
            fy = randomLocation ? (int)((Math.random()*0.3+0.6)*height) : fy;  
            graphics.setColor(null==foreColor ? generateRandomColor() : foreColor);  
            //����֤���ַ���ʾ��ͼ����  
            graphics.drawString(textCode.charAt(i)+"", fx, fy);  
            fx += fsize * 0.9;  
        }  
        graphics.dispose();  
        return bufferedImage;  
    }  
}
