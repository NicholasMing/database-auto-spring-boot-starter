package cn.lastmiles.database.auto;

public class StringUtil {
    public static final char UNDERLINE = '_';

    /**
     * 下划线格式字符串转换为驼峰格式字符串,首字母大写
     *
     * @param param
     */
    public static String camelToUnderline(String param) {
        if (param==null||"".equals(param.trim())){
            return "";
        }
        int len=param.length();
        StringBuilder sb=new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c=param.charAt(i);
            if (Character.isUpperCase(c)){
                sb.append(UNDERLINE);
                sb.append(Character.toLowerCase(c));
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
