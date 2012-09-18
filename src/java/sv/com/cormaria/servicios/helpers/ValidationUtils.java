/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.helpers;

import java.util.regex.Pattern;

/**
 *
 * @author romorales
 */
public class ValidationUtils {
  public static boolean validarNIT(String nit){
  System.out.println("NIT: "+nit +" Length: " +nit.toString().trim().length());
  //return true;
  if (nit == null){
	  return false;
  }
  if (nit.trim().length()!=14){
    return false;
  }
  if (!Pattern.matches("^\\d*$", nit)){
	  return false;
  }
  
  if (nit.toString().trim().equals("00000000000000")){
    return false;
  }
  if (nit.toString().trim().equals("12171707801026")){
    return true;
  }
  if (nit.toString().trim().equals("12171103801062")){
    return true;
  }
    String ls_dvnit , ls_valor , ls_posi14;
    int li_sum=0, li_factor=0, li_pos=0, li_residuo=0, li_digver=0;
    ls_valor = nit.substring(0,13);
    ls_posi14 = nit.substring(13,14);
    int ctd=0;
//    System.out.println("Parte que se validara" + ls_valor);
//    System.out.println("Digito Verificado"+ls_posi14);
//    System.out.println("Valor del if "+ls_valor.substring(10, 13));
    if (Integer.parseInt(ls_valor.substring(10, 13)) <= 100){
      for (li_pos=0; li_pos<13;li_pos++){
        ctd=li_pos+1;
//        System.out.println("Caracter: "+ls_valor.substring(li_pos, li_pos+1));
        li_sum = li_sum + Integer.parseInt(ls_valor.substring(li_pos, li_pos+1)) * (15 - (ctd));
      }
//      System.out.println("Valor de la sumatoria" + li_sum);
      li_digver =  li_sum % 11;

      if (li_digver == 10) {
            li_digver = 0;
      }
    }else{
      for (li_pos=0; li_pos <13; li_pos++){
        ctd=li_pos+1;
        Double nu2 = new Double(Math.round((ctd + 4) / 6));
        System.out.println("Valor de numero que se saco aparte: bigDecimal: " + nu2+ " Double: "+ ((ctd + 4) / 6));
        int brt= nu2.intValue();
        li_factor = (3 + 6 * brt) - ctd;
//        System.out.println("Li Factor: "+li_factor);
        li_sum = li_sum + Integer.parseInt(ls_valor.substring(li_pos,li_pos+1)) * li_factor;
//        System.out.println("li_pos: " + ctd);
      }
      li_residuo =  li_sum % 11;

      if (li_residuo > 1 ){
         li_digver = 11 - li_residuo;
      }else{
          li_digver = 0;
      }
    }
    if (ls_posi14.equals(String.valueOf(li_digver).trim())){
        return true;
    }else{
        return false;
    }
  }    
  
  public static boolean validarDUI(String dui){
   try {
     //System.out.println("Numero de DUI"+dui);
	 if (dui == null){
            return false;
	 }
	 if (dui == "000000000"){
            return false;
	 }
	 if (dui.trim().length() != 9){
            return false;
	 }
	 if (!Pattern.matches("^\\d*$", dui)){
            return false;
         }

     double l_suma = 0;
     int l_cont = 8;
     int l_no_dui = Integer.parseInt(dui.substring(0,8));
     //System.out.println("Datos sustraido"+dui.substring(0,8));
     String l_digito = dui.substring(8,9);
     //System.out.println("Digito Verificador: " + l_digito);
     String l_ChNodui = null;
     double l_TmpNmb = 0;
     double l_resto = 0;
     String l_dgtvrf = "0";

     l_no_dui = l_no_dui + 100000000;
     l_ChNodui = String.valueOf(l_no_dui).trim().substring(1, 9);
     //System.out.println("l_ChNodui: "+l_ChNodui);

     while (l_cont > 0){
       //if (l_cont > 8) {
       //  l_TmpNmb = Double.parseDouble(l_ChNodui.substring(l_cont -1));
       //}else {
         l_TmpNmb = Double.parseDouble(l_ChNodui.substring(l_cont - 1, l_cont));
       //}
       //System.out.println("Datos del While" + l_TmpNmb);
       l_suma = l_suma + (l_TmpNmb * (8 - l_cont + 2));

      //System.out.println("Suma"+l_suma);
       l_cont = l_cont - 1;
       //System.out.println("Contador: "+l_cont);
     }
     //System.out.println(l_suma);
     l_resto = (10D - (l_suma % 10D));
     //System.out.println(l_resto);
     if (l_resto == 10){
       l_dgtvrf = "0";
     } else{
       l_dgtvrf = String.valueOf((int)l_resto);
     }
     //System.out.println("Valor resultante" + l_dgtvrf);
     if (l_dgtvrf.equals(l_digito)){
       return true; // DUI Correcto
     } else{
       return false; // DUI Incorrecto
     }
   }
   catch (Exception ex){
     ex.printStackTrace();
   }
    return true;
  }
  
}