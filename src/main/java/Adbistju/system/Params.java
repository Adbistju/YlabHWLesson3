package Adbistju.system;

import Adbistju.system.models.ParamsModel;

public class Params {
    public static ParamsModel addParams(String[] args){
        ParamsModel paramsModel;
        if(args.length == 0){
            throw new IllegalArgumentException();
        }else{
            paramsModel = new ParamsModel();
        }
        for (int i = 0; i < args.length; i++) {
            if(args[i].equals("-f") && paramsModel != null){
                paramsModel.setFilePath(addFile(args[i+1]));
                paramsModel.setSearchParam(addParam("*"));
            }else if(args[i].equals("-s")&& i+1 <= args.length && paramsModel != null && args.length >=4){
                paramsModel.setSearchParam(addParam(args[i+1]));
            }
        }
        return paramsModel;
    }

    private static String addFile(String filePath){
        return filePath;
    }

    private static String addParam(String param){
        char[] chars = param.toCharArray();
        if(chars[0] == '‘'){
            return constructParam(chars);
        }else{
            return constructParamFileName(chars);
        }
    }
//        String filePath = "D:\\!\\10.xml";

    private static String constructParam(char[] chars){
        String param = "";
        for (int i = 1; i < chars.length-1; i++) {
            param = param+chars[i];
        }
        return param;
    }

    private static String constructParamFileName(char[] chars){
        String param = "";
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == '*'){
                param = param + "(\\W|\\w|\\d|\\D)*";
            }else{
                param = param+chars[i];
            }
        }
        return param;
    }
}
