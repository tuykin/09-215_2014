/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelapplication;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author DEAkishin
 */

//преобразование даты в привычный вид
public class MyDateFormatter {
    public static String format(Date date){
        Format dateFormatter = new SimpleDateFormat("dd.MM.yyyy");
        return dateFormatter.format(date);
    }
}
