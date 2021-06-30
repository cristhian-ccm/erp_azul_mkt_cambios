package up.erp.service.util;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.math.BigDecimal;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class SendMail {
    private final JavaMailSender javaMailSender;

    public SendMail(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void verificarEmail(String nombre, String key, String email) {

        System.out.println("Sending Email...");
        try {

            MimeMessage message = javaMailSender.createMimeMessage();

            message.setSubject("Verificación de correo", "UTF-8");
            MimeMessageHelper helper;
            helper = new MimeMessageHelper(message, true);
            helper.setFrom("grupoupgradeperu@gmail.com");
//            helper.setTo(new String[]{"c.alxndr.pl@gmail.com", "alejandro2833@hotmail.com", "cesar.palo@upgrade.com.pe", "julio.serrano@upgrade.com.pe", "luis.aleman@upgrade.com.pe", "evander.torres@upgrade.com.pe"});
            helper.setTo(email);

            helper.setText("" +
                   "   <a href=\"https://www.upgrade.com.pe\" style=\"text-decoration:none;color:#24c1ff\" target=\"_blank\">\n" +
                    "                                    Consultancy Grupo Upgrade\n" +
                    "                                </a>"+
                    "<table cellpadding=\"5\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                    "    <tbody><tr style=\"border-color:transparent\">\n" +
                    "        <td align=\"center\" style=\"border-collapse:collapse;border-color:transparent\">\n" +
                    "            <table cellpadding=\"0\" cellspacing=\"0\" width=\"600px\" border=\"0\" bgcolor=\"#FFFFFF\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5\">\n" +
                    "                <tbody>\n" +
                    "                <tr style=\"border-color:transparent\">\n" +
                    "                    <td border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;border-color:transparent\">\n" +
                    "                        <table cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;width:100%\" border=\"0\" width=\"100%\">\n" +
                    "                            <tbody><tr style=\"border-color:transparent\">\n" +
                    "                                <th width=\"600\" style=\"border-color:transparent;font-weight:400;text-align:left;vertical-align:top\" cellpadding=\"0\" cellspacing=\"0\" align=\"left\" valign=\"top\">\n" +
                    "                                    <table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;background-color:#fff\" bgcolor=\"#FFFFFF\">\n" +
                    "                                        <tbody><tr style=\"border-color:transparent\">\n" +
                    "                                            <td cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;border-color:transparent\">\n" +
                    "                                                <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;background-color:#fff\" bgcolor=\"#FFFFFF\">\n" +
                    "                                                    <tbody>\n" +
                    "                                                    <tr  style=\"border-color:transparent\">\n" +
                    "                                                        <td style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\">\n" +
                    "                                                        </td>\n" +
                    "                                                        <td  width=\"520\" style=\"border-collapse:collapse;border-color:transparent;vertical-align:top; background: #193d84\" valign=\"top\">\n" +
                    "                                                            <div  style=\"color:#444;font-family:Arial;Helvetica Neue;,Helvetica,sans-serif;font-size:14px;line-height:1.5;display:block;height:40;width:100%\" height=\"40\" width=\"100%\">\n" +
                    "                                                                <img border=\"0\" width=\"250\" height=\"auto\" align=\"left\" alt=\"test-logo\" src=\"https://www.upgrade.com.pe/Principal/img/LogoBlanco.png\" style=\"text-decoration:none;border:0;height:auto;line-height:100%;outline:0;margin:0;display:block\">\n" +
                    "                                                            </div>\n" +
                    "                                                        </td>\n" +
                    "                                                        <td style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                    "                                                    </tr>\n" +
                    "                                                    <tr style=\"border-color:transparent\">\n" +
                    "                                                        <td colspan=\"3\" width=\"100%\" height=\"15\" style=\"border-collapse:collapse;border-color:transparent\"></td>\n" +
                    "                                                    </tr>\n" +
                    "                                                    </tbody>\n" +
                    "                                                </table>\n" +
                    "                                            </td>\n" +
                    "                                        </tr>\n" +
                    "                                        </tbody>\n" +
                    "                                    </table>\n" +
                    "                                    <table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;background-color:#fff\" bgcolor=\"#FFFFFF\">\n" +
                    "                                        <tbody><tr style=\"border-color:transparent\">\n" +
                    "                                            <td cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;border-color:transparent\">\n" +
                    "                                                <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;background-color:#fff;font-weight:normal;margin:0\" bgcolor=\"#FFFFFF\">\n" +
                    "                                                    <tbody><tr style=\"border-color:transparent\">\n" +
                    "                                                        <td colspan=\"3\" width=\"100%\" height=\"15\" style=\"border-collapse:collapse;border-color:transparent\"></td>\n" +
                    "                                                    </tr>\n" +
                    "                                                    <tr style=\"border-color:transparent\">\n" +
                    "                                                        <td style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                    "                                                        <td width=\"520\" style=\"border-collapse:collapse;border-color:transparent;vertical-align:top\" valign=\"top\">\n" +
                    "                                                            <p style=\"font-size:inherit;line-height:1.5;margin:0 0 10px;color:inherit;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-weight:normal;padding:0\">\n" +
                    "                                                                <span style=\"font-size:14px\"><strong>Hola " + nombre +"</strong></span>\n" +
                    "                                                            </p>\n" +
                    "                                                        </td>\n" +
                    "                                                        <td style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                    "                                                    </tr>\n" +
                    "                                                    </tbody>\n" +
                    "                                                </table>\n" +
                    "                                            </td>\n" +
                    "                                        </tr>\n" +
                    "                                        </tbody>\n" +
                    "                                    </table>\n" +
                    "\n" +
                    "                                    <table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;background-color:#fff\" bgcolor=\"#FFFFFF\">\n" +
                    "                                        <tbody><tr style=\"border-color:transparent\">\n" +
                    "                                            <td cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;border-color:transparent\">\n" +
                    "                                                <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;background-color:#fff;font-weight:normal;margin:0\" bgcolor=\"#FFFFFF\">\n" +
                    "                                                    <tbody><tr style=\"border-color:transparent\">\n" +
                    "                                                        <td colspan=\"3\" width=\"100%\" height=\"15\" style=\"border-collapse:collapse;border-color:transparent\"></td>\n" +
                    "                                                    </tr>\n" +
                    "                                                    <tr style=\"border-color:transparent\">\n" +
                    "                                                        <td style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                    "                                                        <td width=\"520\" style=\"border-collapse:collapse;border-color:transparent;vertical-align:top\" valign=\"top\">\n" +
                    "                                                            <p style=\"font-size:14PX;line-height:1.5;margin:0 0 10px;color:inherit;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-weight:normal;padding:0\">\n" +
                    "                                                                <span style=\"font-size:14px\">Has completado tu registro, para confirmar tu email has click en el siguiente link <strong>\n" +
                    "   <a href=\"https://upgrade.com.pe/#/verify-email/" +key +"\" style=\"text-decoration:none;color:#24c1ff\" target=\"_blank\">\n" +
                            "                                   confirmar \n" +
                            "                                </a>" +
                    "                                                                   </strong>\n" +
                    "                                                                </span>\n" +
                    "                                                            </p>\n" +
                    "                                                            <p>\n" +
                    "                                                                <span>Si tiene alguna duda nos ubicamos en<strong> Urb.Magisterial II B-4, José Abelardo Quiñones\n" +
                    "                                                            </strong> en los siquientes horarios:</span></p>\n" +
                    "                                                            <li>De Lunes a Viernes 9:00 am - 7:00 pm</li>\n" +
                    "                                                            <li>Sábados 9:00 am - 1:00 pm</li>\n" +
                    "                                                        </td>\n" +
                    "                                                        <td style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                    "                                                    </tr>\n" +
                    "                                                    <tr style=\"border-color:transparent\">\n" +
                    "                                                        <td colspan=\"3\" width=\"100%\" height=\"20\" style=\"border-collapse:collapse;border-color:transparent\"></td>\n" +
                    "                                                    </tr>\n" +
                    "                                                    </tbody>\n" +
                    "                                                </table>\n" +
                    "                                            </td>\n" +
                    "                                        </tr>\n" +
                    "                                        </tbody>\n" +
                    "                                    </table>\n" +
                    "                                </th>\n" +
                    "                            </tr>\n" +
                    "                            </tbody></table>\n" +
                    "                    </td>\n" +
                    "                </tr>\n" +
                    "                <tr style=\"border-color:transparent\">\n" +
                    "                    <td border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;border-color:transparent\">\n" +
                    "                        <table cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;width:100%\" border=\"0\" width=\"100%\">\n" +
                    "                            <tbody><tr style=\"border-color:transparent\">\n" +
                    "                                <th width=\"600\" style=\"border-color:transparent;font-weight:400;text-align:left;vertical-align:top\" cellpadding=\"0\" cellspacing=\"0\" class=\"m_-4400337760845399296tc\" align=\"left\" valign=\"top\">\n" +
                    "                                    <table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;background-color:#fff\" bgcolor=\"#FFFFFF\">\n" +
                    "                                        <tbody><tr style=\"border-color:transparent\">\n" +
                    "                                            <td cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;border-color:transparent\">\n" +
                    "                                                <div class=\"m_-4400337760845399296block-divider\" style=\"color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;background-color:#fff;padding-bottom:30px;padding-left:40px;padding-right:40px;padding-top:20px\" bgcolor=\"#FFFFFF\">\n" +
                    "                                                    <hr id=\"m_-4400337760845399296iout_block_10_element_0\" style=\"margin:0;border-bottom:0;border-left:0;border-right:0;border-top-color:#e3e3e3;border-top-style:solid;border-top-width:1px\"></div>\n" +
                    "                                            </td>\n" +
                    "                                        </tr>\n" +
                    "                                        </tbody></table>\n" +
                    "                                </th>\n" +
                    "                            </tr>\n" +
                    "                            </tbody></table>\n" +
                    "                    </td>\n" +
                    "                </tr>\n" +
                    "                <tr style=\"border-color:transparent\">\n" +
                    "                    <td border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;border-color:transparent\">\n" +
                    "                        <table cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;width:100%\" border=\"0\" width=\"100%\">\n" +
                    "                            <tbody><tr style=\"border-color:transparent\">\n" +
                    "                                <th width=\"300\" style=\"border-color:transparent;font-weight:400;text-align:left;vertical-align:top\" cellpadding=\"0\" cellspacing=\"0\" align=\"left\" valign=\"top\">\n" +
                    "                                    <table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;background-color:#fff\" bgcolor=\"#FFFFFF\">\n" +
                    "                                        <tbody><tr style=\"border-color:transparent\">\n" +
                    "                                            <td cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;border-color:transparent\">\n" +
                    "                                                <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;background-color:#fff;font-weight:normal;height:108px;margin:0\" bgcolor=\"#FFFFFF\" height=\"108\">\n" +
                    "                                                    <tbody><tr style=\"border-color:transparent\">\n" +
                    "                                                        <td class=\"m_-4400337760845399296expander\" colspan=\"3\" width=\"100%\" height=\"15\" style=\"border-collapse:collapse;border-color:transparent\"></td>\n" +
                    "                                                    </tr>\n" +
                    "                                                    <tr  style=\"border-color:transparent\">\n" +
                    "                                                        <td style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                    "                                                        <td width=\"220\" height=\"93\" style=\"border-collapse:collapse;border-color:transparent;vertical-align:top\" valign=\"top\">\n" +
                    "                                                            <p style=\"font-size:inherit;line-height:1.5;margin:0 0 10px;color:inherit;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-weight:normal;padding:0\"><span style=\"color:#888888\">Atención al Cliente:</span></p>\n" +
                    "                                                            <p style=\"font-size:inherit;line-height:1.5;margin:0 0 10px;color:inherit;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-weight:normal;padding:0\"><span style=\"color:#888888\"><span style=\"color:#24c1ff\"><a style=\"text-decoration:none;color:#24c1ff\" target=\"_blank\">(054) 201476</a></span></span></p>\n" +
                    "                                                            <p style=\"font-size:inherit;line-height:1.5;margin:0 0 10px;color:inherit;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-weight:normal;padding:0\"><span style=\"color:#888888\"><span style=\"color:#24c1ff\"><a style=\"text-decoration:none;color:#24c1ff\"  target=\"_blank\">atencion.cliente@upgrade.com.pe</a></span></span></p>\n" +
                    "                                                        </td>\n" +
                    "                                                        <td class=\"m_-4400337760845399296gutter\" style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                    "                                                    </tr>\n" +
                    "                                                    </tbody></table>\n" +
                    "                                            </td>\n" +
                    "                                        </tr>\n" +
                    "                                        </tbody></table>\n" +
                    "                                </th>\n" +
                    "                                <th width=\"300\" style=\"border-color:transparent;font-weight:400;text-align:left;vertical-align:top\" cellpadding=\"0\" cellspacing=\"0\" class=\"m_-4400337760845399296tc\" align=\"left\" valign=\"top\">\n" +
                    "                                    <table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;background-color:#fff\" bgcolor=\"#FFFFFF\">\n" +
                    "                                        <tbody><tr style=\"border-color:transparent\">\n" +
                    "                                            <td cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;border-color:transparent\">\n" +
                    "                                                <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" id=\"m_-4400337760845399296wout_block_out_block_7\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;background-color:#fff;font-weight:normal;height:46px;margin:0\" bgcolor=\"#FFFFFF\" height=\"46\">\n" +
                    "                                                    <tbody><tr style=\"border-color:transparent\">\n" +
                    "                                                        <td class=\"m_-4400337760845399296expander\" colspan=\"3\" width=\"100%\" height=\"15\" style=\"border-collapse:collapse;border-color:transparent\"></td>\n" +
                    "                                                    </tr>\n" +
                    "                                                    <tr class=\"m_-4400337760845399296content-row\" style=\"border-color:transparent\">\n" +
                    "                                                        <td class=\"m_-4400337760845399296gutter\" style=\"border-collapse:collapse;border-color:transparent;width:20px!important\" width=\"20\" height=\"100%\"></td>\n" +
                    "                                                        <td class=\"m_-4400337760845399296content-cell\" width=\"240\" height=\"31\" style=\"border-collapse:collapse;border-color:transparent;vertical-align:top\" valign=\"top\">\n" +
                    "                                                            <p style=\"font-size:inherit;line-height:1.5;margin:0 0 10px;color:inherit;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-weight:normal;padding:0\"><span style=\"color:#888888\">Visita nuestras redes sociales:</span></p>\n" +
                    "                                                        </td>\n" +
                    "                                                        <td class=\"m_-4400337760845399296gutter\" style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                    "                                                    </tr>\n" +
                    "                                                    </tbody></table>\n" +
                    "                                            </td>\n" +
                    "                                        </tr>\n" +
                    "                                        </tbody></table>\n" +
                    "                                    <table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;background-color:#fff\" bgcolor=\"#FFFFFF\">\n" +
                    "                                        <tbody><tr style=\"border-color:transparent\">\n" +
                    "                                            <td cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;border-color:transparent\">\n" +
                    "                                                <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;background-color:#fff;height:62px;text-align:left\" bgcolor=\"#FFFFFF\" height=\"62\" align=\"left\">\n" +
                    "                                                    <tbody><tr class=\"m_-4400337760845399296content-row\" style=\"border-color:transparent\">\n" +
                    "                                                        <td class=\"m_-4400337760845399296gutter\" style=\"border-collapse:collapse;border-color:transparent;width:10px!important\" width=\"10\" height=\"100%\"></td>\n" +
                    "                                                        <td class=\"m_-4400337760845399296content-cell\" width=\"275\" height=\"62\" style=\"border-collapse:collapse;border-color:transparent;vertical-align:top\" valign=\"top\">\n" +
                    "                                                            <table class=\"m_-4400337760845399296social\" cellpadding=\"5\" border=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1;border-color:transparent;border-style:none;border-width:0;border:0;border-spacing:0;display:inline-block\">\n" +
                    "                                                                <tbody><tr style=\"border-color:transparent\">\n" +
                    "                                                                    <th class=\"m_-4400337760845399296social_element\" style=\"border-color:transparent;font-family:Arial,sans-serif;font-size:13px;line-height:32px;padding:2px 5px;font-weight:400;text-align:left;border-style:none;border-width:0;border:0\" align=\"left\">\n" +
                    "                                                                        <a style=\"text-decoration:none;color:#24c1ff\"  style=\"text-decoration:none;border:0;height:auto;line-height:100%;outline:0;border-color:transparent;border-style:none;border-width:0;display:block;margin:5px\" vspace=\"5\" hspace=\"5\" title=\"Facebook\" width=\"32\" height=\"auto\">\n" +
                    "                                                                            <img src=\"https://upload.wikimedia.org/wikipedia/commons/thumb/f/fb/Facebook_icon_2013.svg/300px-Facebook_icon_2013.svg.png\" alt=\"Facebook\" height=\"40\" width=\"auto\">\n" +
                    "                                                                        </a>\n" +
                    "                                                                    </th>\n" +
                    "                                                                </tr>\n" +
                    "                                                                </tbody></table>\n" +
                    "                                                        </td>\n" +
                    "                                                        <td class=\"m_-4400337760845399296gutter\" style=\"border-collapse:collapse;border-color:transparent;width:15px!important\" width=\"15\" height=\"100%\"></td>\n" +
                    "                                                    </tr>\n" +
                    "                                                    </tbody></table>\n" +
                    "                                            </td>\n" +
                    "                                        </tr>\n" +
                    "                                        </tbody></table>\n" +
                    "                                </th>\n" +
                    "                            </tr>\n" +
                    "                            </tbody></table>\n" +
                    "                    </td>\n" +
                    "                </tr>\n" +
                    "                </tbody></table>\n" +
                    "            <table width=\"600px\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5\">\n" +
                    "                <tbody><tr style=\"border-color:transparent\">\n" +
                    "                    <td style=\"border-collapse:collapse;border-color:transparent;text-align:center\" align=\"center\">\n" +
                    "                        <div align=\"center\" style=\"color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;padding-bottom:8px;padding-top:8px\">\n" +
                    "                            <p style=\"font-size:11px;line-height:1.5;margin:0;color:#777;font-family:Verdana,Arial,sans-serif\">Enviado a través de</p>\n" +
                    "                            <span>\n" +
                    "                                <a href=\"https://www.upgrade.com.pe/\" style=\"text-decoration:none;color:#24c1ff\" target=\"_blank\">\n" +
                    "                                    Consultancy Grupo Upgrade\n" +
                    "                                </a>\n" +
                    "                    </td>\n" +
                    "                </tr>\n" +
                    "                </tbody></table>\n" +
                    "        </td>\n" +
                    "    </tr>\n" +
                    "    </tbody>\n" +
                    "</table>", true);
            javaMailSender.send(message);
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
        System.out.println("Done");
    }

    public void resetPassword(String nombre, String key, String email){
        System.out.println("Sending Email...");
        String url_dev = "https://localhost:4200/#/reset-password";
        String url_prod = "https://upgrade.com.pe/#/reset-password";
        try {

            MimeMessage message = javaMailSender.createMimeMessage();
            message.setSubject("Cambio de contraseña", "UTF-8");
            MimeMessageHelper helper;
            helper = new MimeMessageHelper(message, true);
            helper.setFrom("grupoupgradeperu@gmail.com");
//            helper.setTo(new String[]{"c.alxndr.pl@gmail.com", "alejandro2833@hotmail.com", "cesar.palo@upgrade.com.pe", "julio.serrano@upgrade.com.pe", "luis.aleman@upgrade.com.pe", "evander.torres@upgrade.com.pe"});
            helper.setTo(email);

            helper.setText("" + "<table cellpadding=\"5\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                            "    <tbody><tr style=\"border-color:transparent\">\n" +
                            "        <td align=\"center\" style=\"border-collapse:collapse;border-color:transparent\">\n" +
                            "            <table cellpadding=\"0\" cellspacing=\"0\" width=\"600px\" border=\"0\" bgcolor=\"#FFFFFF\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5\">\n" +
                            "                <tbody>\n" +
                            "                <tr style=\"border-color:transparent\">\n" +
                            "                    <td border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;border-color:transparent\">\n" +
                            "                        <table cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;width:100%\" border=\"0\" width=\"100%\">\n" +
                            "                            <tbody><tr style=\"border-color:transparent\">\n" +
                            "                                <th width=\"600\" style=\"border-color:transparent;font-weight:400;text-align:left;vertical-align:top\" cellpadding=\"0\" cellspacing=\"0\" align=\"left\" valign=\"top\">\n" +
                            "                                    <table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;background-color:#fff\" bgcolor=\"#FFFFFF\">\n" +
                            "                                        <tbody><tr style=\"border-color:transparent\">\n" +
                            "                                            <td cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;border-color:transparent\">\n" +
                            "                                                <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;background-color:#fff\" bgcolor=\"#FFFFFF\">\n" +
                            "                                                    <tbody>\n" +
                            "                                                    <tr  style=\"border-color:transparent\">\n" +
                            "                                                        <td style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\">\n" +
                            "                                                        </td>\n" +
                            "                                                        <td  width=\"520\" style=\"border-collapse:collapse;border-color:transparent;vertical-align:top; background: #193d84\" valign=\"top\">\n" +
                            "                                                            <div  style=\"color:#444;font-family:Arial;Helvetica Neue;,Helvetica,sans-serif;font-size:14px;line-height:1.5;display:block;height:40;width:100%\" height=\"40\" width=\"100%\">\n" +
                            "                                                                <img border=\"0\" width=\"250\" height=\"auto\" align=\"left\" alt=\"test-logo\" src=\"https://www.upgrade.com.pe/Principal/img/LogoBlanco.png\" style=\"text-decoration:none;border:0;height:auto;line-height:100%;outline:0;margin:0;display:block\">\n" +
                            "                                                            </div>\n" +
                            "                                                        </td>\n" +
                            "                                                        <td style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                            "                                                    </tr>\n" +
                            "                                                    <tr style=\"border-color:transparent\">\n" +
                            "                                                        <td colspan=\"3\" width=\"100%\" height=\"15\" style=\"border-collapse:collapse;border-color:transparent\"></td>\n" +
                            "                                                    </tr>\n" +
                            "                                                    </tbody>\n" +
                            "                                                </table>\n" +
                            "                                            </td>\n" +
                            "                                        </tr>\n" +
                            "                                        </tbody>\n" +
                            "                                    </table>\n" +
                            "                                    <table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;background-color:#fff\" bgcolor=\"#FFFFFF\">\n" +
                            "                                        <tbody><tr style=\"border-color:transparent\">\n" +
                            "                                            <td cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;border-color:transparent\">\n" +
                            "                                                <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;background-color:#fff;font-weight:normal;margin:0\" bgcolor=\"#FFFFFF\">\n" +
                            "                                                    <tbody><tr style=\"border-color:transparent\">\n" +
                            "                                                        <td colspan=\"3\" width=\"100%\" height=\"15\" style=\"border-collapse:collapse;border-color:transparent\"></td>\n" +
                            "                                                    </tr>\n" +
                            "                                                    <tr style=\"border-color:transparent\">\n" +
                            "                                                        <td style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                            "                                                        <td width=\"520\" style=\"border-collapse:collapse;border-color:transparent;vertical-align:top\" valign=\"top\">\n" +
                            "                                                            <p style=\"font-size:inherit;line-height:1.5;margin:0 0 10px;color:inherit;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-weight:normal;padding:0\">\n" +
                            "                                                                <span style=\"font-size:14px\"><strong>Hola " + nombre +"</strong></span>\n" +
                            "                                                            </p>\n" +
                            "                                                        </td>\n" +
                            "                                                        <td style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                            "                                                    </tr>\n" +
                            "                                                    </tbody>\n" +
                            "                                                </table>\n" +
                            "                                            </td>\n" +
                            "                                        </tr>\n" +
                            "                                        </tbody>\n" +
                            "                                    </table>\n" +
                            "\n" +
                            "                                    <table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;background-color:#fff\" bgcolor=\"#FFFFFF\">\n" +
                            "                                        <tbody><tr style=\"border-color:transparent\">\n" +
                            "                                            <td cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;border-color:transparent\">\n" +
                            "                                                <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;background-color:#fff;font-weight:normal;margin:0\" bgcolor=\"#FFFFFF\">\n" +
                            "                                                    <tbody><tr style=\"border-color:transparent\">\n" +
                            "                                                        <td colspan=\"3\" width=\"100%\" height=\"15\" style=\"border-collapse:collapse;border-color:transparent\"></td>\n" +
                            "                                                    </tr>\n" +
                            "                                                    <tr style=\"border-color:transparent\">\n" +
                            "                                                        <td style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                            "                                                        <td width=\"520\" style=\"border-collapse:collapse;border-color:transparent;vertical-align:top\" valign=\"top\">\n" +
                            "                                                            <p style=\"font-size:14PX;line-height:1.5;margin:0 0 10px;color:inherit;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-weight:normal;padding:0\">\n" +
                            "                                                                <span style=\"font-size:14px\">Has solicitado reestablecimiento de contraseña, el siguiente link que es válido por 24 horas para realizar el cambio: <a href=\""+ url_prod +"/"+ email + "/" + key +"\" style=\"text-decoration:none;color:#24c1ff\" target=\"_blank\">" +
                            "click aquí para reestablecer contraseña </a>" +
                            "                                                                </span>\n" +
                            "                                                            </p>\n" +
                            "                                                            <p>\n" +
                            "                                                                <span>Si tiene alguna duda nos ubicamos en<strong> Urb.Magisterial II B-4, José Abelardo Quiñones\n" +
                            "                                                            </strong> en los siquientes horarios:</span></p>\n" +
                            "                                                            <li>De Lunes a Viernes 9:00 am - 7:00 pm</li>\n" +
                            "                                                            <li>Sábados 9:00 am - 1:00 pm</li>\n" +
                            "                                                        </td>\n" +
                            "                                                        <td style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                            "                                                    </tr>\n" +
                            "                                                    <tr style=\"border-color:transparent\">\n" +
                            "                                                        <td colspan=\"3\" width=\"100%\" height=\"20\" style=\"border-collapse:collapse;border-color:transparent\"></td>\n" +
                            "                                                    </tr>\n" +
                            "                                                    </tbody>\n" +
                            "                                                </table>\n" +
                            "                                            </td>\n" +
                            "                                        </tr>\n" +
                            "                                        </tbody>\n" +
                            "                                    </table>\n" +
                            "                                </th>\n" +
                            "                            </tr>\n" +
                            "                            </tbody></table>\n" +
                            "                    </td>\n" +
                            "                </tr>\n" +
                            "                <tr style=\"border-color:transparent\">\n" +
                            "                    <td border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;border-color:transparent\">\n" +
                            "                        <table cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;width:100%\" border=\"0\" width=\"100%\">\n" +
                            "                            <tbody><tr style=\"border-color:transparent\">\n" +
                            "                                <th width=\"600\" style=\"border-color:transparent;font-weight:400;text-align:left;vertical-align:top\" cellpadding=\"0\" cellspacing=\"0\" class=\"m_-4400337760845399296tc\" align=\"left\" valign=\"top\">\n" +
                            "                                    <table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;background-color:#fff\" bgcolor=\"#FFFFFF\">\n" +
                            "                                        <tbody><tr style=\"border-color:transparent\">\n" +
                            "                                            <td cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;border-color:transparent\">\n" +
                            "                                                <div class=\"m_-4400337760845399296block-divider\" style=\"color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;background-color:#fff;padding-bottom:30px;padding-left:40px;padding-right:40px;padding-top:20px\" bgcolor=\"#FFFFFF\">\n" +
                            "                                                    <hr id=\"m_-4400337760845399296iout_block_10_element_0\" style=\"margin:0;border-bottom:0;border-left:0;border-right:0;border-top-color:#e3e3e3;border-top-style:solid;border-top-width:1px\"></div>\n" +
                            "                                            </td>\n" +
                            "                                        </tr>\n" +
                            "                                        </tbody></table>\n" +
                            "                                </th>\n" +
                            "                            </tr>\n" +
                            "                            </tbody></table>\n" +
                            "                    </td>\n" +
                            "                </tr>\n" +
                            "                <tr style=\"border-color:transparent\">\n" +
                            "                    <td border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;border-color:transparent\">\n" +
                            "                        <table cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;width:100%\" border=\"0\" width=\"100%\">\n" +
                            "                            <tbody><tr style=\"border-color:transparent\">\n" +
                            "                                <th width=\"300\" style=\"border-color:transparent;font-weight:400;text-align:left;vertical-align:top\" cellpadding=\"0\" cellspacing=\"0\" align=\"left\" valign=\"top\">\n" +
                            "                                    <table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;background-color:#fff\" bgcolor=\"#FFFFFF\">\n" +
                            "                                        <tbody><tr style=\"border-color:transparent\">\n" +
                            "                                            <td cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;border-color:transparent\">\n" +
                            "                                                <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;background-color:#fff;font-weight:normal;height:108px;margin:0\" bgcolor=\"#FFFFFF\" height=\"108\">\n" +
                            "                                                    <tbody><tr style=\"border-color:transparent\">\n" +
                            "                                                        <td class=\"m_-4400337760845399296expander\" colspan=\"3\" width=\"100%\" height=\"15\" style=\"border-collapse:collapse;border-color:transparent\"></td>\n" +
                            "                                                    </tr>\n" +
                            "                                                    <tr  style=\"border-color:transparent\">\n" +
                            "                                                        <td style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                            "                                                        <td width=\"220\" height=\"93\" style=\"border-collapse:collapse;border-color:transparent;vertical-align:top\" valign=\"top\">\n" +
                            "                                                            <p style=\"font-size:inherit;line-height:1.5;margin:0 0 10px;color:inherit;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-weight:normal;padding:0\"><span style=\"color:#888888\">Atención al Cliente:</span></p>\n" +
                            "                                                            <p style=\"font-size:inherit;line-height:1.5;margin:0 0 10px;color:inherit;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-weight:normal;padding:0\"><span style=\"color:#888888\"><span style=\"color:#24c1ff\"><a style=\"text-decoration:none;color:#24c1ff\" target=\"_blank\">(054) 201476</a></span></span></p>\n" +
                            "                                                            <p style=\"font-size:inherit;line-height:1.5;margin:0 0 10px;color:inherit;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-weight:normal;padding:0\"><span style=\"color:#888888\"><span style=\"color:#24c1ff\"><a style=\"text-decoration:none;color:#24c1ff\"  target=\"_blank\">atencion.cliente@upgrade.com.pe</a></span></span></p>\n" +
                            "                                                        </td>\n" +
                            "                                                        <td class=\"m_-4400337760845399296gutter\" style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                            "                                                    </tr>\n" +
                            "                                                    </tbody></table>\n" +
                            "                                            </td>\n" +
                            "                                        </tr>\n" +
                            "                                        </tbody></table>\n" +
                            "                                </th>\n" +
                            "                                <th width=\"300\" style=\"border-color:transparent;font-weight:400;text-align:left;vertical-align:top\" cellpadding=\"0\" cellspacing=\"0\" class=\"m_-4400337760845399296tc\" align=\"left\" valign=\"top\">\n" +
                            "                                    <table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;background-color:#fff\" bgcolor=\"#FFFFFF\">\n" +
                            "                                        <tbody><tr style=\"border-color:transparent\">\n" +
                            "                                            <td cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;border-color:transparent\">\n" +
                            "                                                <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" id=\"m_-4400337760845399296wout_block_out_block_7\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;background-color:#fff;font-weight:normal;height:46px;margin:0\" bgcolor=\"#FFFFFF\" height=\"46\">\n" +
                            "                                                    <tbody><tr style=\"border-color:transparent\">\n" +
                            "                                                        <td class=\"m_-4400337760845399296expander\" colspan=\"3\" width=\"100%\" height=\"15\" style=\"border-collapse:collapse;border-color:transparent\"></td>\n" +
                            "                                                    </tr>\n" +
                            "                                                    <tr class=\"m_-4400337760845399296content-row\" style=\"border-color:transparent\">\n" +
                            "                                                        <td class=\"m_-4400337760845399296gutter\" style=\"border-collapse:collapse;border-color:transparent;width:20px!important\" width=\"20\" height=\"100%\"></td>\n" +
                            "                                                        <td class=\"m_-4400337760845399296content-cell\" width=\"240\" height=\"31\" style=\"border-collapse:collapse;border-color:transparent;vertical-align:top\" valign=\"top\">\n" +
                            "                                                            <p style=\"font-size:inherit;line-height:1.5;margin:0 0 10px;color:inherit;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-weight:normal;padding:0\"><span style=\"color:#888888\">Visita nuestras redes sociales:</span></p>\n" +
                            "                                                        </td>\n" +
                            "                                                        <td class=\"m_-4400337760845399296gutter\" style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                            "                                                    </tr>\n" +
                            "                                                    </tbody></table>\n" +
                            "                                            </td>\n" +
                            "                                        </tr>\n" +
                            "                                        </tbody></table>\n" +
                            "                                    <table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;background-color:#fff\" bgcolor=\"#FFFFFF\">\n" +
                            "                                        <tbody><tr style=\"border-color:transparent\">\n" +
                            "                                            <td cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;border-color:transparent\">\n" +
                            "                                                <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;background-color:#fff;height:62px;text-align:left\" bgcolor=\"#FFFFFF\" height=\"62\" align=\"left\">\n" +
                            "                                                    <tbody><tr class=\"m_-4400337760845399296content-row\" style=\"border-color:transparent\">\n" +
                            "                                                        <td class=\"m_-4400337760845399296gutter\" style=\"border-collapse:collapse;border-color:transparent;width:10px!important\" width=\"10\" height=\"100%\"></td>\n" +
                            "                                                        <td class=\"m_-4400337760845399296content-cell\" width=\"275\" height=\"62\" style=\"border-collapse:collapse;border-color:transparent;vertical-align:top\" valign=\"top\">\n" +
                            "                                                            <table class=\"m_-4400337760845399296social\" cellpadding=\"5\" border=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1;border-color:transparent;border-style:none;border-width:0;border:0;border-spacing:0;display:inline-block\">\n" +
                            "                                                                <tbody><tr style=\"border-color:transparent\">\n" +
                            "                                                                    <th class=\"m_-4400337760845399296social_element\" style=\"border-color:transparent;font-family:Arial,sans-serif;font-size:13px;line-height:32px;padding:2px 5px;font-weight:400;text-align:left;border-style:none;border-width:0;border:0\" align=\"left\">\n" +
                            "                                                                        <a style=\"text-decoration:none;color:#24c1ff\"  style=\"text-decoration:none;border:0;height:auto;line-height:100%;outline:0;border-color:transparent;border-style:none;border-width:0;display:block;margin:5px\" vspace=\"5\" hspace=\"5\" title=\"Facebook\" width=\"32\" height=\"auto\">\n" +
                            "                                                                            <img src=\"https://upload.wikimedia.org/wikipedia/commons/thumb/f/fb/Facebook_icon_2013.svg/300px-Facebook_icon_2013.svg.png\" alt=\"Facebook\" height=\"40\" width=\"auto\">\n" +
                            "                                                                        </a>\n" +
                            "                                                                    </th>\n" +
                            "                                                                </tr>\n" +
                            "                                                                </tbody></table>\n" +
                            "                                                        </td>\n" +
                            "                                                        <td class=\"m_-4400337760845399296gutter\" style=\"border-collapse:collapse;border-color:transparent;width:15px!important\" width=\"15\" height=\"100%\"></td>\n" +
                            "                                                    </tr>\n" +
                            "                                                    </tbody></table>\n" +
                            "                                            </td>\n" +
                            "                                        </tr>\n" +
                            "                                        </tbody></table>\n" +
                            "                                </th>\n" +
                            "                            </tr>\n" +
                            "                            </tbody></table>\n" +
                            "                    </td>\n" +
                            "                </tr>\n" +
                            "                </tbody></table>\n" +
                            "            <table width=\"600px\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5\">\n" +
                            "                <tbody><tr style=\"border-color:transparent\">\n" +
                            "                    <td style=\"border-collapse:collapse;border-color:transparent;text-align:center\" align=\"center\">\n" +
                            "                        <div align=\"center\" style=\"color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;padding-bottom:8px;padding-top:8px\">\n" +
                            "                            <p style=\"font-size:11px;line-height:1.5;margin:0;color:#777;font-family:Verdana,Arial,sans-serif\">Enviado a través de</p>\n" +
                            "                            <span>\n" +
                            "                                <a href=\"https://www.upgrade.com.pe\" style=\"text-decoration:none;color:#24c1ff\" target=\"_blank\">\n" +
                            "                                    Consultancy Grupo Upgrade\n" +
                            "                                </a>\n" +
                            "                    </td>\n" +
                            "                </tr>\n" +
                            "                </tbody></table>\n" +
                            "        </td>\n" +
                            "    </tr>\n" +
                            "    </tbody>\n" +
                            "</table>"
                    , true);
            javaMailSender.send(message);
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
        System.out.println("Done");
    }

    public void resetPasswordOld(String nombre, String passw, String email){
        System.out.println("Sending Email...");
        try {

            MimeMessage message = javaMailSender.createMimeMessage();
            message.setSubject("Reseteo de contraseña", "UTF-8");
            MimeMessageHelper helper;
            helper = new MimeMessageHelper(message, true);
            helper.setFrom("grupoupgradeperu@gmail.com");
//            helper.setTo(new String[]{"c.alxndr.pl@gmail.com", "alejandro2833@hotmail.com", "cesar.palo@upgrade.com.pe", "julio.serrano@upgrade.com.pe", "luis.aleman@upgrade.com.pe", "evander.torres@upgrade.com.pe"});
            helper.setTo(email);

            helper.setText("" + "<table cellpadding=\"5\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                            "    <tbody><tr style=\"border-color:transparent\">\n" +
                            "        <td align=\"center\" style=\"border-collapse:collapse;border-color:transparent\">\n" +
                            "            <table cellpadding=\"0\" cellspacing=\"0\" width=\"600px\" border=\"0\" bgcolor=\"#FFFFFF\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5\">\n" +
                            "                <tbody>\n" +
                            "                <tr style=\"border-color:transparent\">\n" +
                            "                    <td border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;border-color:transparent\">\n" +
                            "                        <table cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;width:100%\" border=\"0\" width=\"100%\">\n" +
                            "                            <tbody><tr style=\"border-color:transparent\">\n" +
                            "                                <th width=\"600\" style=\"border-color:transparent;font-weight:400;text-align:left;vertical-align:top\" cellpadding=\"0\" cellspacing=\"0\" align=\"left\" valign=\"top\">\n" +
                            "                                    <table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;background-color:#fff\" bgcolor=\"#FFFFFF\">\n" +
                            "                                        <tbody><tr style=\"border-color:transparent\">\n" +
                            "                                            <td cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;border-color:transparent\">\n" +
                            "                                                <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;background-color:#fff\" bgcolor=\"#FFFFFF\">\n" +
                            "                                                    <tbody>\n" +
                            "                                                    <tr  style=\"border-color:transparent\">\n" +
                            "                                                        <td style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\">\n" +
                            "                                                        </td>\n" +
                            "                                                        <td  width=\"520\" style=\"border-collapse:collapse;border-color:transparent;vertical-align:top; background: #193d84\" valign=\"top\">\n" +
                            "                                                            <div  style=\"color:#444;font-family:Arial;Helvetica Neue;,Helvetica,sans-serif;font-size:14px;line-height:1.5;display:block;height:40;width:100%\" height=\"40\" width=\"100%\">\n" +
                            "                                                                <img border=\"0\" width=\"250\" height=\"auto\" align=\"left\" alt=\"test-logo\" src=\"https://www.upgrade.com.pe/Principal/img/LogoBlanco.png\" style=\"text-decoration:none;border:0;height:auto;line-height:100%;outline:0;margin:0;display:block\">\n" +
                            "                                                            </div>\n" +
                            "                                                        </td>\n" +
                            "                                                        <td style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                            "                                                    </tr>\n" +
                            "                                                    <tr style=\"border-color:transparent\">\n" +
                            "                                                        <td colspan=\"3\" width=\"100%\" height=\"15\" style=\"border-collapse:collapse;border-color:transparent\"></td>\n" +
                            "                                                    </tr>\n" +
                            "                                                    </tbody>\n" +
                            "                                                </table>\n" +
                            "                                            </td>\n" +
                            "                                        </tr>\n" +
                            "                                        </tbody>\n" +
                            "                                    </table>\n" +
                            "                                    <table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;background-color:#fff\" bgcolor=\"#FFFFFF\">\n" +
                            "                                        <tbody><tr style=\"border-color:transparent\">\n" +
                            "                                            <td cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;border-color:transparent\">\n" +
                            "                                                <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;background-color:#fff;font-weight:normal;margin:0\" bgcolor=\"#FFFFFF\">\n" +
                            "                                                    <tbody><tr style=\"border-color:transparent\">\n" +
                            "                                                        <td colspan=\"3\" width=\"100%\" height=\"15\" style=\"border-collapse:collapse;border-color:transparent\"></td>\n" +
                            "                                                    </tr>\n" +
                            "                                                    <tr style=\"border-color:transparent\">\n" +
                            "                                                        <td style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                            "                                                        <td width=\"520\" style=\"border-collapse:collapse;border-color:transparent;vertical-align:top\" valign=\"top\">\n" +
                            "                                                            <p style=\"font-size:inherit;line-height:1.5;margin:0 0 10px;color:inherit;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-weight:normal;padding:0\">\n" +
                            "                                                                <span style=\"font-size:14px\"><strong>Hola " + nombre +"</strong></span>\n" +
                            "                                                            </p>\n" +
                            "                                                        </td>\n" +
                            "                                                        <td style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                            "                                                    </tr>\n" +
                            "                                                    </tbody>\n" +
                            "                                                </table>\n" +
                            "                                            </td>\n" +
                            "                                        </tr>\n" +
                            "                                        </tbody>\n" +
                            "                                    </table>\n" +
                            "\n" +
                            "                                    <table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;background-color:#fff\" bgcolor=\"#FFFFFF\">\n" +
                            "                                        <tbody><tr style=\"border-color:transparent\">\n" +
                            "                                            <td cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;border-color:transparent\">\n" +
                            "                                                <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;background-color:#fff;font-weight:normal;margin:0\" bgcolor=\"#FFFFFF\">\n" +
                            "                                                    <tbody><tr style=\"border-color:transparent\">\n" +
                            "                                                        <td colspan=\"3\" width=\"100%\" height=\"15\" style=\"border-collapse:collapse;border-color:transparent\"></td>\n" +
                            "                                                    </tr>\n" +
                            "                                                    <tr style=\"border-color:transparent\">\n" +
                            "                                                        <td style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                            "                                                        <td width=\"520\" style=\"border-collapse:collapse;border-color:transparent;vertical-align:top\" valign=\"top\">\n" +
                            "                                                            <p style=\"font-size:14PX;line-height:1.5;margin:0 0 10px;color:inherit;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-weight:normal;padding:0\">\n" +
                            "                                                                <span style=\"font-size:14px\">Has solicitado un nueva contraseña, tu nueva contraseña es: <strong> " + passw +"</strong>\n" +
                            "                                                                </span>\n" +
                            "                                                            </p>\n" +
                            "                                                            <p>\n" +
                            "                                                                <span>Si tiene alguna duda nos ubicamos en<strong> Urb.Magisterial II B-4, José Abelardo Quiñones\n" +
                            "                                                            </strong> en los siquientes horarios:</span></p>\n" +
                            "                                                            <li>De Lunes a Viernes 9:00 am - 7:00 pm</li>\n" +
                            "                                                            <li>Sábados 9:00 am - 1:00 pm</li>\n" +
                            "                                                        </td>\n" +
                            "                                                        <td style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                            "                                                    </tr>\n" +
                            "                                                    <tr style=\"border-color:transparent\">\n" +
                            "                                                        <td colspan=\"3\" width=\"100%\" height=\"20\" style=\"border-collapse:collapse;border-color:transparent\"></td>\n" +
                            "                                                    </tr>\n" +
                            "                                                    </tbody>\n" +
                            "                                                </table>\n" +
                            "                                            </td>\n" +
                            "                                        </tr>\n" +
                            "                                        </tbody>\n" +
                            "                                    </table>\n" +
                            "                                </th>\n" +
                            "                            </tr>\n" +
                            "                            </tbody></table>\n" +
                            "                    </td>\n" +
                            "                </tr>\n" +
                            "                <tr style=\"border-color:transparent\">\n" +
                            "                    <td border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;border-color:transparent\">\n" +
                            "                        <table cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;width:100%\" border=\"0\" width=\"100%\">\n" +
                            "                            <tbody><tr style=\"border-color:transparent\">\n" +
                            "                                <th width=\"600\" style=\"border-color:transparent;font-weight:400;text-align:left;vertical-align:top\" cellpadding=\"0\" cellspacing=\"0\" class=\"m_-4400337760845399296tc\" align=\"left\" valign=\"top\">\n" +
                            "                                    <table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;background-color:#fff\" bgcolor=\"#FFFFFF\">\n" +
                            "                                        <tbody><tr style=\"border-color:transparent\">\n" +
                            "                                            <td cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;border-color:transparent\">\n" +
                            "                                                <div class=\"m_-4400337760845399296block-divider\" style=\"color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;background-color:#fff;padding-bottom:30px;padding-left:40px;padding-right:40px;padding-top:20px\" bgcolor=\"#FFFFFF\">\n" +
                            "                                                    <hr id=\"m_-4400337760845399296iout_block_10_element_0\" style=\"margin:0;border-bottom:0;border-left:0;border-right:0;border-top-color:#e3e3e3;border-top-style:solid;border-top-width:1px\"></div>\n" +
                            "                                            </td>\n" +
                            "                                        </tr>\n" +
                            "                                        </tbody></table>\n" +
                            "                                </th>\n" +
                            "                            </tr>\n" +
                            "                            </tbody></table>\n" +
                            "                    </td>\n" +
                            "                </tr>\n" +
                            "                <tr style=\"border-color:transparent\">\n" +
                            "                    <td border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;border-color:transparent\">\n" +
                            "                        <table cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;width:100%\" border=\"0\" width=\"100%\">\n" +
                            "                            <tbody><tr style=\"border-color:transparent\">\n" +
                            "                                <th width=\"300\" style=\"border-color:transparent;font-weight:400;text-align:left;vertical-align:top\" cellpadding=\"0\" cellspacing=\"0\" align=\"left\" valign=\"top\">\n" +
                            "                                    <table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;background-color:#fff\" bgcolor=\"#FFFFFF\">\n" +
                            "                                        <tbody><tr style=\"border-color:transparent\">\n" +
                            "                                            <td cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;border-color:transparent\">\n" +
                            "                                                <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;background-color:#fff;font-weight:normal;height:108px;margin:0\" bgcolor=\"#FFFFFF\" height=\"108\">\n" +
                            "                                                    <tbody><tr style=\"border-color:transparent\">\n" +
                            "                                                        <td class=\"m_-4400337760845399296expander\" colspan=\"3\" width=\"100%\" height=\"15\" style=\"border-collapse:collapse;border-color:transparent\"></td>\n" +
                            "                                                    </tr>\n" +
                            "                                                    <tr  style=\"border-color:transparent\">\n" +
                            "                                                        <td style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                            "                                                        <td width=\"220\" height=\"93\" style=\"border-collapse:collapse;border-color:transparent;vertical-align:top\" valign=\"top\">\n" +
                            "                                                            <p style=\"font-size:inherit;line-height:1.5;margin:0 0 10px;color:inherit;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-weight:normal;padding:0\"><span style=\"color:#888888\">Atención al Cliente:</span></p>\n" +
                            "                                                            <p style=\"font-size:inherit;line-height:1.5;margin:0 0 10px;color:inherit;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-weight:normal;padding:0\"><span style=\"color:#888888\"><span style=\"color:#24c1ff\"><a style=\"text-decoration:none;color:#24c1ff\" target=\"_blank\">(054) 201476</a></span></span></p>\n" +
                            "                                                            <p style=\"font-size:inherit;line-height:1.5;margin:0 0 10px;color:inherit;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-weight:normal;padding:0\"><span style=\"color:#888888\"><span style=\"color:#24c1ff\"><a style=\"text-decoration:none;color:#24c1ff\"  target=\"_blank\">atencion.cliente@upgrade.com.pe</a></span></span></p>\n" +
                            "                                                        </td>\n" +
                            "                                                        <td class=\"m_-4400337760845399296gutter\" style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                            "                                                    </tr>\n" +
                            "                                                    </tbody></table>\n" +
                            "                                            </td>\n" +
                            "                                        </tr>\n" +
                            "                                        </tbody></table>\n" +
                            "                                </th>\n" +
                            "                                <th width=\"300\" style=\"border-color:transparent;font-weight:400;text-align:left;vertical-align:top\" cellpadding=\"0\" cellspacing=\"0\" class=\"m_-4400337760845399296tc\" align=\"left\" valign=\"top\">\n" +
                            "                                    <table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;background-color:#fff\" bgcolor=\"#FFFFFF\">\n" +
                            "                                        <tbody><tr style=\"border-color:transparent\">\n" +
                            "                                            <td cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;border-color:transparent\">\n" +
                            "                                                <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" id=\"m_-4400337760845399296wout_block_out_block_7\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;background-color:#fff;font-weight:normal;height:46px;margin:0\" bgcolor=\"#FFFFFF\" height=\"46\">\n" +
                            "                                                    <tbody><tr style=\"border-color:transparent\">\n" +
                            "                                                        <td class=\"m_-4400337760845399296expander\" colspan=\"3\" width=\"100%\" height=\"15\" style=\"border-collapse:collapse;border-color:transparent\"></td>\n" +
                            "                                                    </tr>\n" +
                            "                                                    <tr class=\"m_-4400337760845399296content-row\" style=\"border-color:transparent\">\n" +
                            "                                                        <td class=\"m_-4400337760845399296gutter\" style=\"border-collapse:collapse;border-color:transparent;width:20px!important\" width=\"20\" height=\"100%\"></td>\n" +
                            "                                                        <td class=\"m_-4400337760845399296content-cell\" width=\"240\" height=\"31\" style=\"border-collapse:collapse;border-color:transparent;vertical-align:top\" valign=\"top\">\n" +
                            "                                                            <p style=\"font-size:inherit;line-height:1.5;margin:0 0 10px;color:inherit;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-weight:normal;padding:0\"><span style=\"color:#888888\">Visita nuestras redes sociales:</span></p>\n" +
                            "                                                        </td>\n" +
                            "                                                        <td class=\"m_-4400337760845399296gutter\" style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                            "                                                    </tr>\n" +
                            "                                                    </tbody></table>\n" +
                            "                                            </td>\n" +
                            "                                        </tr>\n" +
                            "                                        </tbody></table>\n" +
                            "                                    <table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;background-color:#fff\" bgcolor=\"#FFFFFF\">\n" +
                            "                                        <tbody><tr style=\"border-color:transparent\">\n" +
                            "                                            <td cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;border-color:transparent\">\n" +
                            "                                                <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;background-color:#fff;height:62px;text-align:left\" bgcolor=\"#FFFFFF\" height=\"62\" align=\"left\">\n" +
                            "                                                    <tbody><tr class=\"m_-4400337760845399296content-row\" style=\"border-color:transparent\">\n" +
                            "                                                        <td class=\"m_-4400337760845399296gutter\" style=\"border-collapse:collapse;border-color:transparent;width:10px!important\" width=\"10\" height=\"100%\"></td>\n" +
                            "                                                        <td class=\"m_-4400337760845399296content-cell\" width=\"275\" height=\"62\" style=\"border-collapse:collapse;border-color:transparent;vertical-align:top\" valign=\"top\">\n" +
                            "                                                            <table class=\"m_-4400337760845399296social\" cellpadding=\"5\" border=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1;border-color:transparent;border-style:none;border-width:0;border:0;border-spacing:0;display:inline-block\">\n" +
                            "                                                                <tbody><tr style=\"border-color:transparent\">\n" +
                            "                                                                    <th class=\"m_-4400337760845399296social_element\" style=\"border-color:transparent;font-family:Arial,sans-serif;font-size:13px;line-height:32px;padding:2px 5px;font-weight:400;text-align:left;border-style:none;border-width:0;border:0\" align=\"left\">\n" +
                            "                                                                        <a style=\"text-decoration:none;color:#24c1ff\"  style=\"text-decoration:none;border:0;height:auto;line-height:100%;outline:0;border-color:transparent;border-style:none;border-width:0;display:block;margin:5px\" vspace=\"5\" hspace=\"5\" title=\"Facebook\" width=\"32\" height=\"auto\">\n" +
                            "                                                                            <img src=\"https://upload.wikimedia.org/wikipedia/commons/thumb/f/fb/Facebook_icon_2013.svg/300px-Facebook_icon_2013.svg.png\" alt=\"Facebook\" height=\"40\" width=\"auto\">\n" +
                            "                                                                        </a>\n" +
                            "                                                                    </th>\n" +
                            "                                                                </tr>\n" +
                            "                                                                </tbody></table>\n" +
                            "                                                        </td>\n" +
                            "                                                        <td class=\"m_-4400337760845399296gutter\" style=\"border-collapse:collapse;border-color:transparent;width:15px!important\" width=\"15\" height=\"100%\"></td>\n" +
                            "                                                    </tr>\n" +
                            "                                                    </tbody></table>\n" +
                            "                                            </td>\n" +
                            "                                        </tr>\n" +
                            "                                        </tbody></table>\n" +
                            "                                </th>\n" +
                            "                            </tr>\n" +
                            "                            </tbody></table>\n" +
                            "                    </td>\n" +
                            "                </tr>\n" +
                            "                </tbody></table>\n" +
                            "            <table width=\"600px\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5\">\n" +
                            "                <tbody><tr style=\"border-color:transparent\">\n" +
                            "                    <td style=\"border-collapse:collapse;border-color:transparent;text-align:center\" align=\"center\">\n" +
                            "                        <div align=\"center\" style=\"color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;padding-bottom:8px;padding-top:8px\">\n" +
                            "                            <p style=\"font-size:11px;line-height:1.5;margin:0;color:#777;font-family:Verdana,Arial,sans-serif\">Enviado a través de</p>\n" +
                            "                            <span>\n" +
                            "                                <a href=\"https://www.upgrade.com.pe\" style=\"text-decoration:none;color:#24c1ff\" target=\"_blank\">\n" +
                            "                                    Consultancy Grupo Upgrade\n" +
                            "                                </a>\n" +
                            "                    </td>\n" +
                            "                </tr>\n" +
                            "                </tbody></table>\n" +
                            "        </td>\n" +
                            "    </tr>\n" +
                            "    </tbody>\n" +
                            "</table>"
                    , true);
            javaMailSender.send(message);
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
        System.out.println("Done");
    }

    public void ordenCompra(String nombre, String orden, String email){
        System.out.println("Sending Email Orden...");
        try {

            MimeMessage message = javaMailSender.createMimeMessage();

            message.setSubject("Su compra está siendo procesada", "UTF-8");
            MimeMessageHelper helper;
            helper = new MimeMessageHelper(message, true);
            helper.setFrom("grupoupgradeperu@gmail.com");
//            helper.setTo(new String[]{"c.alxndr.pl@gmail.com", "alejandro2833@hotmail.com", "cesar.palo@upgrade.com.pe", "julio.serrano@upgrade.com.pe", "luis.aleman@upgrade.com.pe", "evander.torres@upgrade.com.pe"});
            helper.setTo(email);

            helper.setText(getBodyMailOrden(nombre, orden), true);
            javaMailSender.send(message);
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
        System.out.println("Done mail orden");
    }

    public String getBodyMailOrden(String nombre, String orden){
        String body = "<table width=\"600\" cellpadding=\"0\" cellspacing=\"0\" style=\"margin-left:auto;margin-right:auto;font-family:Arial,serif;\">\n" +
                "    <tbody>\n" +
                "    <tr  style=\"border-color:transparent\">\n" +
                "        <td style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\">\n" +
                "        </td>\n" +
                "        <td  width=\"520\" style=\"background: #193d84\">\n" +
                "            <img border=\"0\" width=\"250\" height=\"auto\" align=\"left\" alt=\"test-logo\" src=\"https://www.upgrade.com.pe/Principal/img/LogoBlanco.png\">\n" +
                "        </td>\n" +
                "        <td style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                "    </tr>\n" +
                "    <tr style=\"border-color:transparent\">\n" +
                "        <td colspan=\"3\" width=\"100%\" height=\"15\" style=\"border-collapse:collapse;border-color:transparent\"></td>\n" +
                "    </tr>\n" +
                "\n" +
                "    <tr style=\"border-color:transparent\">\n" +
                "        <td style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                "        <td width=\"520\" style=\"border-collapse:collapse;border-color:transparent;vertical-align:top\" valign=\"top\">\n" +
                "            <p style=\"font-size:inherit;line-height:1.5;margin:0 0 10px;color:inherit;font-weight:normal;padding:0\">\n" +
                "                <span style=\"font-size:14px\"><strong>Hola "+ nombre +"</strong></span>\n" +
                "            </p>\n" +
                "            <p style=\"font-size:inherit;line-height:1.5;margin:0 0 10px;color:inherit;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-weight:normal;padding:0\">\n" +
                "                <span style=\"font-size:24px\"><strong>Tu numero de orden es № "+ orden +"</strong></span>\n" +
                "            </p>\n" +
                "        </td>\n" +
                "        <td style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                "    </tr>\n" +
                "    <tr style=\"border-color:transparent\">\n" +
                "        <td style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                "        <td width=\"520\" style=\"border-collapse:collapse;border-color:transparent;vertical-align:top\" valign=\"top\">\n" +
                "            <p style=\"font-size:14PX;line-height:1.5;margin:0 0 10px;color:inherit;font-weight:normal;padding:0\">\n" +
                "                <span style=\"font-size:14px\">Tu orden está siendo procesada, recuerda que puedes comunicarte con nosotros al <strong>(054) 201476</strong> o apersonarte a nuestra sede principal ubicada en\n" +
                "                    <strong>Urb.Magisterial II B-4, José Abelardo Quiñones </strong> en los siquientes horarios:\n" +
                "                </span>\n" +
                "            </p>\n" +
                "            <li>De Lunes a Viernes 9:00 am - 7:00 pm</li>\n" +
                "            <li>Sábados 9:00 am - 1:00 pm</li>\n" +
                "        </td>\n" +
                "        <td style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                "    </tr>\n" +
                "    <tr style=\"border-color:transparent\">\n" +
                "        <td colspan=\"3\" width=\"100%\" height=\"15\" style=\"border-collapse:collapse;border-color:transparent\"></td>\n" +
                "    </tr>\n" +
                "\n" +
                "    <tr style=\"border-color:transparent\">\n" +
                "        <td></td>\n" +
                "        <td style=\"border-bottom: thin solid black;\"></td>\n" +
                "        <td></td>\n" +
                "    </tr>\n" +
                "    <tr style=\"border-color:transparent\">\n" +
                "        <td colspan=\"3\">\n" +
                "            <table>\n" +
                "                <tbody>\n" +
                "                <tr width=\"300\" style=\"border-color:transparent\">\n" +
                "                    <td style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                "                    <td width=\"220\" height=\"93\" style=\"border-collapse:collapse;border-color:transparent;vertical-align:top\" valign=\"top\">\n" +
                "                        <p style=\"font-size:inherit;line-height:1.5;margin:0 0 10px;color:inherit;font-weight:normal;padding:0\"><span style=\"color:#888888\">Atención al Cliente:</span></p>\n" +
                "                        <p style=\"font-size:inherit;line-height:1.5;margin:0 0 10px;color:inherit;font-weight:normal;padding:0\"><span style=\"color:#888888\"><span style=\"color:#24c1ff\"><a style=\"text-decoration:none;color:#24c1ff\" target=\"_blank\">(054) 201476</a></span></span></p>\n" +
                "                        <p style=\"font-size:inherit;line-height:1.5;margin:0 0 10px;color:inherit;font-weight:normal;padding:0\"><span style=\"color:#888888\"><span style=\"color:#24c1ff\"><a style=\"text-decoration:none;color:#24c1ff\"  target=\"_blank\">atencion.cliente@upgrade.com.pe</a></span></span></p>\n" +
                "                    </td>\n" +
                "                    <td class=\"m_-4400337760845399296gutter\" style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                "                    <td width=\"220\" height=\"93\" style=\"border-collapse:collapse;border-color:transparent;vertical-align:top\" valign=\"top\">\n" +
                "                        <p style=\"font-size:inherit;line-height:1.5;margin:0 0 10px;color:inherit;font-weight:normal;padding:0\"><span style=\"color:#888888\">Visita nuestras redes sociales:</span></p>\n" +
                "                        <p style=\"font-size:inherit;line-height:1.5;margin:0 0 10px;color:inherit;font-weight:normal;padding:0\">\n" +
                "                            <span style=\"color:#888888\"><span style=\"color:#24c1ff\">\n" +
                "                            <img src=\"https://upload.wikimedia.org/wikipedia/commons/thumb/f/fb/Facebook_icon_2013.svg/300px-Facebook_icon_2013.svg.png\" alt=\"Facebook\" height=\"40\" width=\"auto\">\n" +
                "                        </span></span>\n" +
                "                        </p>\n" +
                "                    </td>\n" +
                "                    <td style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                "                </tr>\n" +
                "                </tbody>\n" +
                "            </table>\n" +
                "        </td>\n" +
                "    </tr>\n" +
                "    <tr style=\"border-color:transparent\">\n" +
                "        <td colspan=\"3\" style=\"border-collapse:collapse;border-color:transparent;text-align:center\" align=\"center\">\n" +
                "            <div align=\"center\" style=\"color:#444;font-size:14px;line-height:1.5;padding-bottom:8px;padding-top:8px\">\n" +
                "                <p style=\"font-size:11px;line-height:1.5;margin:0;color:#777;font-family:Verdana,Arial,sans-serif\">Enviado a través de</p>\n" +
                "                <span>\n" +
                "                                <a href=\"https://www.upgrade.com.pe/\" style=\"text-decoration:none;color:#24c1ff\" target=\"_blank\">\n" +
                "                                    Consultancy Grupo Upgrade\n" +
                "                                </a>\n" +
                "        </td>\n" +
                "    </tr>\n" +
                "    </tbody>\n" +
                "</table>";
        return body;
    }

    public String getBodyMailSuscripcionCupon(String nombre, String cupon, String monto, String vigencia, Integer precioMin){
        String body = "<table width=\"600\" cellpadding=\"0\" cellspacing=\"0\" style=\"margin-left:auto;margin-right:auto;font-family:Arial,serif;\">\n" +
                "    <tbody>\n" +
                "    <tr  style=\"border-color:transparent\">\n" +
                "        <td style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\">\n" +
                "        </td>\n" +
                "        <td  width=\"520\" style=\"background: #193d84\">\n" +
                "            <img border=\"0\" width=\"250\" height=\"auto\" align=\"left\" alt=\"test-logo\" src=\"https://www.upgrade.com.pe/Principal/img/LogoBlanco.png\">\n" +
                "        </td>\n" +
                "        <td style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                "    </tr>\n" +
                "    <tr style=\"border-color:transparent\">\n" +
                "        <td colspan=\"3\" width=\"100%\" height=\"15\" style=\"border-collapse:collapse;border-color:transparent\"></td>\n" +
                "    </tr>\n" +
                "\n" +
                "    <tr style=\"border-color:transparent\">\n" +
                "        <td style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                "        <td width=\"520\" style=\"border-collapse:collapse;border-color:transparent;vertical-align:top\" valign=\"top\">\n" +
                "            <p style=\"font-size:inherit;line-height:1.5;margin:0 0 10px;color:inherit;font-weight:normal;padding:0\">\n" +
                "                <span style=\"font-size:14px\"><strong>Hola "+ nombre +"</strong></span>\n" +
                "            </p>\n" +
                "            <p style=\"font-size:inherit;line-height:1.5;margin:0 0 10px;color:inherit;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-weight:normal;padding:0\">\n" +
                "                <span style=\"font-size:24px\"><strong>Tu cupón es "+ cupon +"  por S/ "+ monto+"</strong></span>\n" +
                "            </p>\n" +
                "        </td>\n" +
                "        <td style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                "    </tr>\n" +
                "    <tr style=\"border-color:transparent\">\n" +
                "        <td style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                "        <td width=\"520\" style=\"border-collapse:collapse;border-color:transparent;vertical-align:top\" valign=\"top\">\n" +
                "            <p style=\"font-size:14PX;line-height:1.5;margin:0 0 10px;color:inherit;font-weight:normal;padding:0\">\n" +
                "                <span style=\"font-size:14px\">Recuerda que puedes hacer el uso de tu cupón en la compra de  cualquier producto con un monto mínimo de "+ precioMin +" , con vigencia hasta el " + vigencia +
                " también puedes comunicarte con nosotros al <strong>(054) 201476</strong> o apersonarte a nuestra sede principal ubicada en\n" +
                "                    <strong>Urb.Magisterial II B-4, José Abelardo Quiñones </strong> en los siquientes horarios:\n" +
                "                </span>\n" +
                "            </p>\n" +
                "            <li>De Lunes a Viernes 9:00 am - 7:00 pm</li>\n" +
                "            <li>Sábados 9:00 am - 1:00 pm</li>\n" +
                "        </td>\n" +
                "        <td style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                "    </tr>\n" +
                "    <tr style=\"border-color:transparent\">\n" +
                "        <td colspan=\"3\" width=\"100%\" height=\"15\" style=\"border-collapse:collapse;border-color:transparent\"></td>\n" +
                "    </tr>\n" +
                "\n" +
                "    <tr style=\"border-color:transparent\">\n" +
                "        <td></td>\n" +
                "        <td style=\"border-bottom: thin solid black;\"></td>\n" +
                "        <td></td>\n" +
                "    </tr>\n" +
                "    <tr style=\"border-color:transparent\">\n" +
                "        <td colspan=\"3\">\n" +
                "            <table>\n" +
                "                <tbody>\n" +
                "                <tr width=\"300\" style=\"border-color:transparent\">\n" +
                "                    <td style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                "                    <td width=\"220\" height=\"93\" style=\"border-collapse:collapse;border-color:transparent;vertical-align:top\" valign=\"top\">\n" +
                "                        <p style=\"font-size:inherit;line-height:1.5;margin:0 0 10px;color:inherit;font-weight:normal;padding:0\"><span style=\"color:#888888\">Atención al Cliente:</span></p>\n" +
                "                        <p style=\"font-size:inherit;line-height:1.5;margin:0 0 10px;color:inherit;font-weight:normal;padding:0\"><span style=\"color:#888888\"><span style=\"color:#24c1ff\"><a style=\"text-decoration:none;color:#24c1ff\" target=\"_blank\">(054) 201476</a></span></span></p>\n" +
                "                        <p style=\"font-size:inherit;line-height:1.5;margin:0 0 10px;color:inherit;font-weight:normal;padding:0\"><span style=\"color:#888888\"><span style=\"color:#24c1ff\"><a style=\"text-decoration:none;color:#24c1ff\"  target=\"_blank\">atencion.cliente@upgrade.com.pe</a></span></span></p>\n" +
                "                    </td>\n" +
                "                    <td class=\"m_-4400337760845399296gutter\" style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                "                    <td width=\"220\" height=\"93\" style=\"border-collapse:collapse;border-color:transparent;vertical-align:top\" valign=\"top\">\n" +
                "                        <p style=\"font-size:inherit;line-height:1.5;margin:0 0 10px;color:inherit;font-weight:normal;padding:0\"><span style=\"color:#888888\">Visita nuestras redes sociales:</span></p>\n" +
                "                        <p style=\"font-size:inherit;line-height:1.5;margin:0 0 10px;color:inherit;font-weight:normal;padding:0\">\n" +
                "                            <span style=\"color:#888888\"><span style=\"color:#24c1ff\">\n" +
                "                            <img src=\"https://upload.wikimedia.org/wikipedia/commons/thumb/f/fb/Facebook_icon_2013.svg/300px-Facebook_icon_2013.svg.png\" alt=\"Facebook\" height=\"40\" width=\"auto\">\n" +
                "                        </span></span>\n" +
                "                        </p>\n" +
                "                    </td>\n" +
                "                    <td style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                "                </tr>\n" +
                "                </tbody>\n" +
                "            </table>\n" +
                "        </td>\n" +
                "    </tr>\n" +
                "    <tr style=\"border-color:transparent\">\n" +
                "        <td colspan=\"3\" style=\"border-collapse:collapse;border-color:transparent;text-align:center\" align=\"center\">\n" +
                "            <div align=\"center\" style=\"color:#444;font-size:14px;line-height:1.5;padding-bottom:8px;padding-top:8px\">\n" +
                "                <p style=\"font-size:11px;line-height:1.5;margin:0;color:#777;font-family:Verdana,Arial,sans-serif\">Enviado a través de</p>\n" +
                "                <span>\n" +
                "                                <a href=\"https://www.upgrade.com.pe/\" style=\"text-decoration:none;color:#24c1ff\" target=\"_blank\">\n" +
                "                                    Consultancy Grupo Upgrade\n" +
                "                                </a>\n" +
                "        </td>\n" +
                "    </tr>\n" +
                "    </tbody>\n" +
                "</table>";
        return body;
    }

    public String getBodyMailSuscripcionCuponMtto(String nombre, String cupon, String monto, String vigencia, Integer precioMin){
        String body = "<table width=\"600\" cellpadding=\"0\" cellspacing=\"0\" style=\"margin-left:auto;margin-right:auto;font-family:Arial,serif;\">\n" +
                "    <tbody>\n" +
                "    <tr  style=\"border-color:transparent\">\n" +
                "        <td style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\">\n" +
                "        </td>\n" +
                "        <td  width=\"520\" style=\"background: #193d84\">\n" +
                "            <img border=\"0\" width=\"250\" height=\"auto\" align=\"left\" alt=\"test-logo\" src=\"https://www.upgrade.com.pe/Principal/img/LogoBlanco.png\">\n" +
                "        </td>\n" +
                "        <td style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                "    </tr>\n" +
                "    <tr style=\"border-color:transparent\">\n" +
                "        <td colspan=\"3\" width=\"100%\" height=\"15\" style=\"border-collapse:collapse;border-color:transparent\"></td>\n" +
                "    </tr>\n" +
                "\n" +
                "    <tr style=\"border-color:transparent\">\n" +
                "        <td style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                "        <td width=\"520\" style=\"border-collapse:collapse;border-color:transparent;vertical-align:top\" valign=\"top\">\n" +
                "            <p style=\"font-size:inherit;line-height:1.5;margin:0 0 10px;color:inherit;font-weight:normal;padding:0\">\n" +
                "                <span style=\"font-size:14px\"><strong>Hola, "+ nombre +"</strong> gracias por suscribirte, estamos de aniversario y queremos premiarte.</span>\n" +
                "            </p>\n" +
                "            <p style=\"font-size:inherit;line-height:1.5;margin:0 0 10px;color:inherit;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-weight:normal;padding:0\">\n" +
                "                <span style=\"font-size:14px\">Utiliza el siguiente código <strong>"+ cupon +"</strong> para el mantenimiento preventivo a tu equipo GRATIS.</span>\n" +
                "            </p>\n" +
                "            <p style=\"font-size:inherit;line-height:1.5;margin:0 0 10px;color:inherit;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-weight:normal;padding:0\">\n" +
                "                <span style=\"font-size:10px\">*Cupón válido hasta el " +  vigencia + "</span>\n" +
                "            </p>\n" +
                "        </td>\n" +
                "        <td style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                "    </tr>\n" +
                "    <tr style=\"border-color:transparent\">\n" +
                "        <td style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                "        <td width=\"520\" style=\"border-collapse:collapse;border-color:transparent;vertical-align:top\" valign=\"top\">\n" +
                "            <p style=\"font-size:14PX;line-height:1.5;margin:0 0 10px;color:inherit;font-weight:normal;padding:0\">\n" +
                "                <span style=\"font-size:14px\">Con este cupón GRUPO UPGRADE te ofrece mantenimiento preventivo de tu equipo GRATIS, el mismo que consta de:" +
                "                </span>\n" +
                "            </p>\n" +
                "            <p style=\"font-size:inherit;line-height:1.5;margin:0 0 10px;color:inherit;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-weight:normal;padding:0\">\n" +
                "                <span style=\"font-size:14px\">1.\tMANTENIMIENTO DE HARDWARE: incluye retirarle polvo de los componentes limpieza de componentes electrónicos, cambio de pasta termina en procesadores, lubricación con aceite siliconado de componentes de ventilación que lo requieran.</span>\n" +
                "            </p>\n" +
                "            <p style=\"font-size:inherit;line-height:1.5;margin:0 0 10px;color:inherit;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-weight:normal;padding:0\">\n" +
                "                <span style=\"font-size:14px\">2.\tMANTENIMIENTO DE SOFTWARE: incluye ejecutar herramientas de software para desinfección corrección y optimización del sistema operativo, actualización de antivirus y drivers. </span>\n" +
                "            </p>\n" +
                "            <p style=\"font-size:inherit;line-height:1.5;margin:0 0 10px;color:inherit;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-weight:normal;padding:0\">\n" +
                "                <span style=\"font-size:14px\">Todos los equipos deberán de ser traídos a la siguiente dirección URB. MAGISTERIAL II B4 – YANAHUARA (CERCA AL ESTADIO UMACOLLO O AL OVALO QUIÑONES), para que puedan ser revisados por nuestro soporte técnico.</span>\n" +
                "            </p>\n" +
                "           <br><p style=\"font-size:14PX;line-height:1.5;margin:0 0 10px;color:inherit;font-weight:normal;padding:0\">\n" +
                "                <span style=\"font-size:14px\">Recuerda que "+
                "  puedes comunicarte con nosotros al <strong>(054) 201476</strong> o apersonarte a nuestra sede principal ubicada en\n" +
                "                    <strong>Urb.Magisterial II B-4, José Abelardo Quiñones </strong> en los siquientes horarios:\n" +
                "                </span>\n" +
                "            </p>\n" +
                "            <li>De Lunes a Viernes 9:00 am - 7:00 pm</li>\n" +
                "            <li>Sábados 9:00 am - 1:00 pm</li>\n" +
                "        </td>\n" +
                "        <td style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                "    </tr>\n" +
                "    <tr style=\"border-color:transparent\">\n" +
                "        <td colspan=\"3\" width=\"100%\" height=\"15\" style=\"border-collapse:collapse;border-color:transparent\"></td>\n" +
                "    </tr>\n" +
                "\n" +
                "    <tr style=\"border-color:transparent\">\n" +
                "        <td></td>\n" +
                "        <td style=\"border-bottom: thin solid black;\"></td>\n" +
                "        <td></td>\n" +
                "    </tr>\n" +
                "    <tr style=\"border-color:transparent\">\n" +
                "        <td colspan=\"3\">\n" +
                "            <table>\n" +
                "                <tbody>\n" +
                "                <tr width=\"300\" style=\"border-color:transparent\">\n" +
                "                    <td style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                "                    <td width=\"220\" height=\"93\" style=\"border-collapse:collapse;border-color:transparent;vertical-align:top\" valign=\"top\">\n" +
                "                        <p style=\"font-size:inherit;line-height:1.5;margin:0 0 10px;color:inherit;font-weight:normal;padding:0\"><span style=\"color:#888888\">Atención al Cliente:</span></p>\n" +
                "                        <p style=\"font-size:inherit;line-height:1.5;margin:0 0 10px;color:inherit;font-weight:normal;padding:0\"><span style=\"color:#888888\"><span style=\"color:#24c1ff\"><a style=\"text-decoration:none;color:#24c1ff\" target=\"_blank\">(054) 201476</a></span></span></p>\n" +
                "                        <p style=\"font-size:inherit;line-height:1.5;margin:0 0 10px;color:inherit;font-weight:normal;padding:0\"><span style=\"color:#888888\"><span style=\"color:#24c1ff\"><a style=\"text-decoration:none;color:#24c1ff\"  target=\"_blank\">atencion.cliente@upgrade.com.pe</a></span></span></p>\n" +
                "                    </td>\n" +
                "                    <td class=\"m_-4400337760845399296gutter\" style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                "                    <td width=\"220\" height=\"93\" style=\"border-collapse:collapse;border-color:transparent;vertical-align:top\" valign=\"top\">\n" +
                "                        <p style=\"font-size:inherit;line-height:1.5;margin:0 0 10px;color:inherit;font-weight:normal;padding:0\"><span style=\"color:#888888\">Visita nuestras redes sociales:</span></p>\n" +
                "                        <p style=\"font-size:inherit;line-height:1.5;margin:0 0 10px;color:inherit;font-weight:normal;padding:0\">\n" +
                "                            <span style=\"color:#888888\"><span style=\"color:#24c1ff\">\n" +
                "                            <img src=\"https://upload.wikimedia.org/wikipedia/commons/thumb/f/fb/Facebook_icon_2013.svg/300px-Facebook_icon_2013.svg.png\" alt=\"Facebook\" height=\"40\" width=\"auto\">\n" +
                "                        </span></span>\n" +
                "                        </p>\n" +
                "                    </td>\n" +
                "                    <td style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                "                </tr>\n" +
                "                </tbody>\n" +
                "            </table>\n" +
                "        </td>\n" +
                "    </tr>\n" +
                "    <tr style=\"border-color:transparent\">\n" +
                "        <td colspan=\"3\" style=\"border-collapse:collapse;border-color:transparent;text-align:center\" align=\"center\">\n" +
                "            <div align=\"center\" style=\"color:#444;font-size:14px;line-height:1.5;padding-bottom:8px;padding-top:8px\">\n" +
                "                <p style=\"font-size:11px;line-height:1.5;margin:0;color:#777;font-family:Verdana,Arial,sans-serif\">Enviado a través de</p>\n" +
                "                <span>\n" +
                "                                <a href=\"https://www.upgrade.com.pe/\" style=\"text-decoration:none;color:#24c1ff\" target=\"_blank\">\n" +
                "                                    Consultancy Grupo Upgrade\n" +
                "                                </a>\n" +
                "        </td>\n" +
                "    </tr>\n" +
                "    </tbody>\n" +
                "</table>";
        return body;
    }

    public void compraDeposito(String nombre, String orden, String email, BigDecimal monto){
        System.out.println("Sending Email Orden...");
        try {

            MimeMessage message = javaMailSender.createMimeMessage();

            message.setSubject("Su compra está siendo procesada, confirmar pago", "UTF-8");
            MimeMessageHelper helper;
            helper = new MimeMessageHelper(message, true);
            helper.setFrom("grupoupgradeperu@gmail.com");
//            helper.setTo(new String[]{"c.alxndr.pl@gmail.com", "alejandro2833@hotmail.com", "cesar.palo@upgrade.com.pe", "julio.serrano@upgrade.com.pe", "luis.aleman@upgrade.com.pe", "evander.torres@upgrade.com.pe"});
            helper.setTo(email);

            helper.setText(getBodyMailDeposito(nombre, orden, monto), true);
            javaMailSender.send(message);
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
        System.out.println("Done mail orden");
    }

    public void mailConCuponPorSuscripcion(String nombre, String cupon, String email, Date vigencia, Integer precioMin, Integer monto){
        System.out.println("Sending Email Orden...");
        try {

            MimeMessage message = javaMailSender.createMimeMessage();

            message.setSubject("¡Gracias por suscribirte!", "UTF-8");
            MimeMessageHelper helper;
            helper = new MimeMessageHelper(message, true);
            helper.setFrom("grupoupgradeperu@gmail.com");
//            helper.setTo(new String[]{"c.alxndr.pl@gmail.com", "alejandro2833@hotmail.com", "cesar.palo@upgrade.com.pe", "julio.serrano@upgrade.com.pe", "luis.aleman@upgrade.com.pe", "evander.torres@upgrade.com.pe"});
            helper.setTo(email);
            Format formatter = new SimpleDateFormat("yyyy-MM-dd");
            String s = formatter.format(vigencia);

            helper.setText(getBodyMailSuscripcionCuponMtto(nombre, cupon, monto+"", s, precioMin), true);
            javaMailSender.send(message);
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
        System.out.println("Done mail orden");
    }

    public String getBodyMailDeposito(String nombre, String orden, BigDecimal monto){
        String body = "<table width=\"600\" cellpadding=\"0\" cellspacing=\"0\" style=\"margin-left:auto;margin-right:auto;font-family:Arial,serif;\">\n" +
                "    <tbody>\n" +
                "    <tr  style=\"border-color:transparent\">\n" +
                "        <td style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\">\n" +
                "        </td>\n" +
                "        <td  width=\"520\" style=\"background: #193d84\">\n" +
                "            <img border=\"0\" width=\"250\" height=\"auto\" align=\"left\" alt=\"test-logo\" src=\"https://www.upgrade.com.pe/Principal/img/LogoBlanco.png\">\n" +
                "        </td>\n" +
                "        <td style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                "    </tr>\n" +
                "    <tr style=\"border-color:transparent\">\n" +
                "        <td colspan=\"3\" width=\"100%\" height=\"15\" style=\"border-collapse:collapse;border-color:transparent\"></td>\n" +
                "    </tr>\n" +
                "\n" +
                "    <tr style=\"border-color:transparent\">\n" +
                "        <td style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                "        <td width=\"520\" style=\"border-collapse:collapse;border-color:transparent;vertical-align:top\" valign=\"top\">\n" +
                "            <p style=\"font-size:inherit;line-height:1.5;margin:0 0 10px;color:inherit;font-weight:normal;padding:0\">\n" +
                "                <span style=\"font-size:14px\"><strong>Hola "+ nombre +"</strong></span>\n" +
                "            </p>\n" +
                "            <p style=\"font-size:inherit;line-height:1.5;margin:0 0 10px;color:inherit;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-weight:normal;padding:0\">\n" +
                "                <span style=\"font-size:24px\"><strong>Tu numero de orden es № "+ orden +"</strong></span>\n" +
                "                <br><span style=\"font-size:24px\"><strong>Monto a depositar es: "+ monto.toString() +"</strong></span>\n" +
                "            </p>\n" +
                "        </td>\n" +
                "        <td style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                "    </tr>\n" +
                "    <tr style=\"border-color:transparent\">\n" +
                "        <td style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                "        <td width=\"520\" style=\"border-collapse:collapse;border-color:transparent;vertical-align:top\" valign=\"top\">\n" +
                "            <p style=\"font-size:14PX;line-height:1.5;margin:0 0 10px;color:inherit;font-weight:normal;padding:0\">\n" +
                "                <span style=\"font-size:14px\">Para continuar con tu compra deberás completar tu pago por uno de los siguientes medios:" +
                "  <ul>Mediante aplicativo de tu banco:</ul>\n" +
                "          <li>Si tienes cuenta BCP, Transferencia entre cuentas: <strong>215-1528133-0-03</strong></li>\n" +
                "          <li>Si no tienes cuenta BCP, Transferencia Interbancaria, CCI: <strong>002-215-001528133003-23</strong></li>\n" +
                "          <ul>En <strong>agente</strong> BCP(Solo si estas en la ciudad de Arequipa): </ul>\n" +
                "          <li>Cuenta: <strong>215-1528133-0-03</strong> BCP Soles</li>\n" +
                "          <ul>En <strong>ventanilla</strong> de un Banco BCP (Si no estas en la ciudad de Arequipa)</ul>\n" +
                "          <li>Cuenta:  <strong>215-1528132-0-93</strong></li>\n" +
                "          <li>* En este caso te pedirán tu código el cual es tu DNI si eres persona natural o tu RUC si eres empresa.</li>\n" +
                "        </div>" +
                "                </span>\n" +
                "            </p>\n" +
                "            <p style=\"font-size:14PX;line-height:1.5;margin:0 0 10px;color:inherit;font-weight:normal;padding:0\">\n" +
                "                <span style=\"font-size:14px\">Luego de hacer el depósito deberás mandar la foto de tu comprobante con el número de orden al siguiente enlace:" +
                        "                                <a href=\"https://wa.me/+51959504118?text=Hola, hice mi depósito el número de orden es: "+ orden+" \" style=\"text-decoration:none;color:#24c1ff\" target=\"_blank\">\n" +
                "                                    Enviar comprobante\n" +
                "                                </a>\n" +
                "                </span>\n" +
                "            </p>\n" +
                "            <p style=\"font-size:14PX;line-height:1.5;margin:0 0 10px;color:inherit;font-weight:normal;padding:0\">\n" +
                "                <span style=\"font-size:14px\">Tienes un plazo de 24 horas para realizar tu pago, recuerda que puedes comunicarte con nosotros al <strong>(054) 201476</strong> o apersonarte a nuestra sede principal ubicada en\n" +
                "                    <strong>Urb.Magisterial II B-4, José Abelardo Quiñones </strong> en los siquientes horarios:\n" +
                "                </span>\n" +
                "            </p>\n" +
                "            <li>De Lunes a Viernes 9:00 am - 7:00 pm</li>\n" +
                "            <li>Sábados 9:00 am - 1:00 pm</li>\n" +
                "        </td>\n" +
                "        <td style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                "    </tr>\n" +
                "    <tr style=\"border-color:transparent\">\n" +
                "        <td colspan=\"3\" width=\"100%\" height=\"15\" style=\"border-collapse:collapse;border-color:transparent\"></td>\n" +
                "    </tr>\n" +
                "\n" +
                "    <tr style=\"border-color:transparent\">\n" +
                "        <td></td>\n" +
                "        <td style=\"border-bottom: thin solid black;\"></td>\n" +
                "        <td></td>\n" +
                "    </tr>\n" +
                "    <tr style=\"border-color:transparent\">\n" +
                "        <td colspan=\"3\">\n" +
                "            <table>\n" +
                "                <tbody>\n" +
                "                <tr width=\"300\" style=\"border-color:transparent\">\n" +
                "                    <td style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                "                    <td width=\"220\" height=\"93\" style=\"border-collapse:collapse;border-color:transparent;vertical-align:top\" valign=\"top\">\n" +
                "                        <p style=\"font-size:inherit;line-height:1.5;margin:0 0 10px;color:inherit;font-weight:normal;padding:0\"><span style=\"color:#888888\">Atención al Cliente:</span></p>\n" +
                "                        <p style=\"font-size:inherit;line-height:1.5;margin:0 0 10px;color:inherit;font-weight:normal;padding:0\"><span style=\"color:#888888\"><span style=\"color:#24c1ff\"><a style=\"text-decoration:none;color:#24c1ff\" target=\"_blank\">(054) 201476</a></span></span></p>\n" +
                "                        <p style=\"font-size:inherit;line-height:1.5;margin:0 0 10px;color:inherit;font-weight:normal;padding:0\"><span style=\"color:#888888\"><span style=\"color:#24c1ff\"><a style=\"text-decoration:none;color:#24c1ff\"  target=\"_blank\">atencion.cliente@upgrade.com.pe</a></span></span></p>\n" +
                "                    </td>\n" +
                "                    <td class=\"m_-4400337760845399296gutter\" style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                "                    <td width=\"220\" height=\"93\" style=\"border-collapse:collapse;border-color:transparent;vertical-align:top\" valign=\"top\">\n" +
                "                        <p style=\"font-size:inherit;line-height:1.5;margin:0 0 10px;color:inherit;font-weight:normal;padding:0\"><span style=\"color:#888888\">Visita nuestras redes sociales:</span></p>\n" +
                "                        <p style=\"font-size:inherit;line-height:1.5;margin:0 0 10px;color:inherit;font-weight:normal;padding:0\">\n" +
                "                            <span style=\"color:#888888\"><span style=\"color:#24c1ff\">\n" +
                "                            <img src=\"https://upload.wikimedia.org/wikipedia/commons/thumb/f/fb/Facebook_icon_2013.svg/300px-Facebook_icon_2013.svg.png\" alt=\"Facebook\" height=\"40\" width=\"auto\">\n" +
                "                        </span></span>\n" +
                "                        </p>\n" +
                "                    </td>\n" +
                "                    <td style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                "                </tr>\n" +
                "                </tbody>\n" +
                "            </table>\n" +
                "        </td>\n" +
                "    </tr>\n" +
                "    <tr style=\"border-color:transparent\">\n" +
                "        <td colspan=\"3\" style=\"border-collapse:collapse;border-color:transparent;text-align:center\" align=\"center\">\n" +
                "            <div align=\"center\" style=\"color:#444;font-size:14px;line-height:1.5;padding-bottom:8px;padding-top:8px\">\n" +
                "                <p style=\"font-size:11px;line-height:1.5;margin:0;color:#777;font-family:Verdana,Arial,sans-serif\">Enviado a través de</p>\n" +
                "                <span>\n" +
                "                                <a href=\"https://www.upgrade.com.pe/\" style=\"text-decoration:none;color:#24c1ff\" target=\"_blank\">\n" +
                "                                    Consultancy Grupo Upgrade\n" +
                "                                </a>\n" +
                "        </td>\n" +
                "    </tr>\n" +
                "    </tbody>\n" +
                "</table>";
        return body;
    }
    
    public void probarEnvio(String nombre, String key, String email) {

        System.out.println("Sending Email...");
        try {

            MimeMessage message = javaMailSender.createMimeMessage();

            message.setSubject("Verificación de correo", "UTF-8");
            MimeMessageHelper helper;
            helper = new MimeMessageHelper(message, true);
            helper.setFrom("grupoupgradeperu@gmail.com");
//            helper.setTo(new String[]{"c.alxndr.pl@gmail.com", "alejandro2833@hotmail.com", "cesar.palo@upgrade.com.pe", "julio.serrano@upgrade.com.pe", "luis.aleman@upgrade.com.pe", "evander.torres@upgrade.com.pe"});
            helper.setTo(email);

            helper.setText("" +
                   "   <a href=\"https://www.upgrade.com.pe\" style=\"text-decoration:none;color:#24c1ff\" target=\"_blank\">\n" +
                    "                                    Consultancy Grupo Upgrade\n" +
                    "                                </a>"+
                    "<table cellpadding=\"5\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                    "    <tbody><tr style=\"border-color:transparent\">\n" +
                    "        <td align=\"center\" style=\"border-collapse:collapse;border-color:transparent\">\n" +
                    "            <table cellpadding=\"0\" cellspacing=\"0\" width=\"600px\" border=\"0\" bgcolor=\"#FFFFFF\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5\">\n" +
                    "                <tbody>\n" +
                    "                <tr style=\"border-color:transparent\">\n" +
                    "                    <td border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;border-color:transparent\">\n" +
                    "                        <table cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;width:100%\" border=\"0\" width=\"100%\">\n" +
                    "                            <tbody><tr style=\"border-color:transparent\">\n" +
                    "                                <th width=\"600\" style=\"border-color:transparent;font-weight:400;text-align:left;vertical-align:top\" cellpadding=\"0\" cellspacing=\"0\" align=\"left\" valign=\"top\">\n" +
                                                       getHeaderMessage()+
                    "                                    <table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;background-color:#fff\" bgcolor=\"#FFFFFF\">\n" +
                    "                                        <tbody><tr style=\"border-color:transparent\">\n" +
                    "                                            <td cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;border-color:transparent\">\n" +
                    "                                                <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;background-color:#fff;font-weight:normal;margin:0\" bgcolor=\"#FFFFFF\">\n" +
                    "                                                    <tbody><tr style=\"border-color:transparent\">\n" +
                    "                                                        <td colspan=\"3\" width=\"100%\" height=\"15\" style=\"border-collapse:collapse;border-color:transparent\"></td>\n" +
                    "                                                    </tr>\n" +
                    "                                                    <tr style=\"border-color:transparent\">\n" +
                    "                                                        <td style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                    "                                                        <td width=\"520\" style=\"border-collapse:collapse;border-color:transparent;vertical-align:top\" valign=\"top\">\n" +
                    "                                                            <p style=\"font-size:inherit;line-height:1.5;margin:0 0 10px;color:inherit;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-weight:normal;padding:0\">\n" +
                    "                                                                <span style=\"font-size:14px\"><strong>Hola " + nombre +"</strong></span>\n" +
                    "                                                            </p>\n" +
                    "                                                        </td>\n" +
                    "                                                        <td style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                    "                                                    </tr>\n" +
                    "                                                    </tbody>\n" +
                    "                                                </table>\n" +
                    "                                            </td>\n" +
                    "                                        </tr>\n" +
                    "                                        </tbody>\n" +
                    "                                    </table>\n" +
                    "\n" +
                    "                                    <table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;background-color:#fff\" bgcolor=\"#FFFFFF\">\n" +
                    "                                        <tbody><tr style=\"border-color:transparent\">\n" +
                    "                                            <td cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;border-color:transparent\">\n" +
                    "                                                <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;background-color:#fff;font-weight:normal;margin:0\" bgcolor=\"#FFFFFF\">\n" +
                    "                                                    <tbody><tr style=\"border-color:transparent\">\n" +
                    "                                                        <td colspan=\"3\" width=\"100%\" height=\"15\" style=\"border-collapse:collapse;border-color:transparent\"></td>\n" +
                    "                                                    </tr>\n" +
                    "                                                    <tr style=\"border-color:transparent\">\n" +
                    "                                                        <td style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                    "                                                        <td width=\"520\" style=\"border-collapse:collapse;border-color:transparent;vertical-align:top\" valign=\"top\">\n" +
                    "                                                            <p style=\"font-size:14PX;line-height:1.5;margin:0 0 10px;color:inherit;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-weight:normal;padding:0\">\n" +
                    "                                                                <span style=\"font-size:14px\">Has completado tu registro, para confirmar tu email has click en el siguiente link <strong>\n" +
                    "   <a href=\"https://upgrade.com.pe/#/verify-email/" +key +"\" style=\"text-decoration:none;color:#24c1ff\" target=\"_blank\">\n" +
                            "                                   confirmar \n" +
                            "                                </a>" +
                    "                                                                   </strong>\n" +
                    "                                                                </span>\n" +
                    "                                                            </p>\n" +
                    "                                                            <p>\n" +
                    "                                                                <span>Si tiene alguna duda nos ubicamos en<strong> Urb.Magisterial II B-4, José Abelardo Quiñones\n" +
                    "                                                            </strong> en los siquientes horarios:</span></p>\n" +
                    "                                                            <li>De Lunes a Viernes 9:00 am - 7:00 pm</li>\n" +
                    "                                                            <li>Sábados 9:00 am - 1:00 pm</li>\n" +
                    "                                                        </td>\n" +
                    "                                                        <td style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                    "                                                    </tr>\n" +
                    "                                                    <tr style=\"border-color:transparent\">\n" +
                    "                                                        <td colspan=\"3\" width=\"100%\" height=\"20\" style=\"border-collapse:collapse;border-color:transparent\"></td>\n" +
                    "                                                    </tr>\n" +
                    "                                                    </tbody>\n" +
                    "                                                </table>\n" +
                    "                                            </td>\n" +
                    "                                        </tr>\n" +
                    "                                        </tbody>\n" +
                    "                                    </table>\n" +
                    "                                </th>\n" +
                    "                            </tr>\n" +
                    "                            </tbody></table>\n" +
                    "                    </td>\n" +
                    "                </tr>\n" +
                    "                <tr style=\"border-color:transparent\">\n" +
                    "                    <td border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;border-color:transparent\">\n" +
                    "                        <table cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;width:100%\" border=\"0\" width=\"100%\">\n" +
                    "                            <tbody><tr style=\"border-color:transparent\">\n" +
                    "                                <th width=\"600\" style=\"border-color:transparent;font-weight:400;text-align:left;vertical-align:top\" cellpadding=\"0\" cellspacing=\"0\" class=\"m_-4400337760845399296tc\" align=\"left\" valign=\"top\">\n" +
                    "                                    <table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;background-color:#fff\" bgcolor=\"#FFFFFF\">\n" +
                    "                                        <tbody><tr style=\"border-color:transparent\">\n" +
                    "                                            <td cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;border-color:transparent\">\n" +
                    "                                                <div class=\"m_-4400337760845399296block-divider\" style=\"color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;background-color:#fff;padding-bottom:30px;padding-left:40px;padding-right:40px;padding-top:20px\" bgcolor=\"#FFFFFF\">\n" +
                    "                                                    <hr id=\"m_-4400337760845399296iout_block_10_element_0\" style=\"margin:0;border-bottom:0;border-left:0;border-right:0;border-top-color:#e3e3e3;border-top-style:solid;border-top-width:1px\"></div>\n" +
                    "                                            </td>\n" +
                    "                                        </tr>\n" +
                    "                                        </tbody></table>\n" +
                    "                                </th>\n" +
                    "                            </tr>\n" +
                    "                            </tbody></table>\n" +
                    "                    </td>\n" +
                    "                </tr>\n" +
                    "                <tr style=\"border-color:transparent\">\n" +
                    "                    <td border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;border-color:transparent\">\n" +
                    "                        <table cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;width:100%\" border=\"0\" width=\"100%\">\n" +
                    "                            <tbody><tr style=\"border-color:transparent\">\n" +
                    "                                <th width=\"300\" style=\"border-color:transparent;font-weight:400;text-align:left;vertical-align:top\" cellpadding=\"0\" cellspacing=\"0\" align=\"left\" valign=\"top\">\n" +
                    "                                    <table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;background-color:#fff\" bgcolor=\"#FFFFFF\">\n" +
                    "                                        <tbody><tr style=\"border-color:transparent\">\n" +
                    "                                            <td cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;border-color:transparent\">\n" +
                    "                                                <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;background-color:#fff;font-weight:normal;height:108px;margin:0\" bgcolor=\"#FFFFFF\" height=\"108\">\n" +
                    "                                                    <tbody><tr style=\"border-color:transparent\">\n" +
                    "                                                        <td class=\"m_-4400337760845399296expander\" colspan=\"3\" width=\"100%\" height=\"15\" style=\"border-collapse:collapse;border-color:transparent\"></td>\n" +
                    "                                                    </tr>\n" +
                    "                                                    <tr  style=\"border-color:transparent\">\n" +
                    "                                                        <td style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                    "                                                        <td width=\"220\" height=\"93\" style=\"border-collapse:collapse;border-color:transparent;vertical-align:top\" valign=\"top\">\n" +
                    "                                                            <p style=\"font-size:inherit;line-height:1.5;margin:0 0 10px;color:inherit;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-weight:normal;padding:0\"><span style=\"color:#888888\">Atención al Cliente:</span></p>\n" +
                    "                                                            <p style=\"font-size:inherit;line-height:1.5;margin:0 0 10px;color:inherit;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-weight:normal;padding:0\"><span style=\"color:#888888\"><span style=\"color:#24c1ff\"><a style=\"text-decoration:none;color:#24c1ff\" target=\"_blank\">(054) 201476</a></span></span></p>\n" +
                    "                                                            <p style=\"font-size:inherit;line-height:1.5;margin:0 0 10px;color:inherit;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-weight:normal;padding:0\"><span style=\"color:#888888\"><span style=\"color:#24c1ff\"><a style=\"text-decoration:none;color:#24c1ff\"  target=\"_blank\">atencion.cliente@upgrade.com.pe</a></span></span></p>\n" +
                    "                                                        </td>\n" +
                    "                                                        <td class=\"m_-4400337760845399296gutter\" style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                    "                                                    </tr>\n" +
                    "                                                    </tbody></table>\n" +
                    "                                            </td>\n" +
                    "                                        </tr>\n" +
                    "                                        </tbody></table>\n" +
                    "                                </th>\n" +
                    "                                <th width=\"300\" style=\"border-color:transparent;font-weight:400;text-align:left;vertical-align:top\" cellpadding=\"0\" cellspacing=\"0\" class=\"m_-4400337760845399296tc\" align=\"left\" valign=\"top\">\n" +
                    "                                    <table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;background-color:#fff\" bgcolor=\"#FFFFFF\">\n" +
                    "                                        <tbody><tr style=\"border-color:transparent\">\n" +
                    "                                            <td cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;border-color:transparent\">\n" +
                    "                                                <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" id=\"m_-4400337760845399296wout_block_out_block_7\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;background-color:#fff;font-weight:normal;height:46px;margin:0\" bgcolor=\"#FFFFFF\" height=\"46\">\n" +
                    "                                                    <tbody><tr style=\"border-color:transparent\">\n" +
                    "                                                        <td class=\"m_-4400337760845399296expander\" colspan=\"3\" width=\"100%\" height=\"15\" style=\"border-collapse:collapse;border-color:transparent\"></td>\n" +
                    "                                                    </tr>\n" +
                    "                                                    <tr class=\"m_-4400337760845399296content-row\" style=\"border-color:transparent\">\n" +
                    "                                                        <td class=\"m_-4400337760845399296gutter\" style=\"border-collapse:collapse;border-color:transparent;width:20px!important\" width=\"20\" height=\"100%\"></td>\n" +
                    "                                                        <td class=\"m_-4400337760845399296content-cell\" width=\"240\" height=\"31\" style=\"border-collapse:collapse;border-color:transparent;vertical-align:top\" valign=\"top\">\n" +
                    "                                                            <p style=\"font-size:inherit;line-height:1.5;margin:0 0 10px;color:inherit;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-weight:normal;padding:0\"><span style=\"color:#888888\">Visita nuestras redes sociales:</span></p>\n" +
                    "                                                        </td>\n" +
                    "                                                        <td class=\"m_-4400337760845399296gutter\" style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                    "                                                    </tr>\n" +
                    "                                                    </tbody></table>\n" +
                    "                                            </td>\n" +
                    "                                        </tr>\n" +
                    "                                        </tbody></table>\n" +
                    "                                    <table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;background-color:#fff\" bgcolor=\"#FFFFFF\">\n" +
                    "                                        <tbody><tr style=\"border-color:transparent\">\n" +
                    "                                            <td cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;border-color:transparent\">\n" +
                    "                                                <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;background-color:#fff;height:62px;text-align:left\" bgcolor=\"#FFFFFF\" height=\"62\" align=\"left\">\n" +
                    "                                                    <tbody><tr class=\"m_-4400337760845399296content-row\" style=\"border-color:transparent\">\n" +
                    "                                                        <td class=\"m_-4400337760845399296gutter\" style=\"border-collapse:collapse;border-color:transparent;width:10px!important\" width=\"10\" height=\"100%\"></td>\n" +
                    "                                                        <td class=\"m_-4400337760845399296content-cell\" width=\"275\" height=\"62\" style=\"border-collapse:collapse;border-color:transparent;vertical-align:top\" valign=\"top\">\n" +
                    "                                                            <table class=\"m_-4400337760845399296social\" cellpadding=\"5\" border=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1;border-color:transparent;border-style:none;border-width:0;border:0;border-spacing:0;display:inline-block\">\n" +
                    "                                                                <tbody><tr style=\"border-color:transparent\">\n" +
                    "                                                                    <th class=\"m_-4400337760845399296social_element\" style=\"border-color:transparent;font-family:Arial,sans-serif;font-size:13px;line-height:32px;padding:2px 5px;font-weight:400;text-align:left;border-style:none;border-width:0;border:0\" align=\"left\">\n" +
                    "                                                                        <a style=\"text-decoration:none;color:#24c1ff\"  style=\"text-decoration:none;border:0;height:auto;line-height:100%;outline:0;border-color:transparent;border-style:none;border-width:0;display:block;margin:5px\" vspace=\"5\" hspace=\"5\" title=\"Facebook\" width=\"32\" height=\"auto\">\n" +
                    "                                                                            <img src=\"https://upload.wikimedia.org/wikipedia/commons/thumb/f/fb/Facebook_icon_2013.svg/300px-Facebook_icon_2013.svg.png\" alt=\"Facebook\" height=\"40\" width=\"auto\">\n" +
                    "                                                                        </a>\n" +
                    "                                                                    </th>\n" +
                    "                                                                </tr>\n" +
                    "                                                                </tbody></table>\n" +
                    "                                                        </td>\n" +
                    "                                                        <td class=\"m_-4400337760845399296gutter\" style=\"border-collapse:collapse;border-color:transparent;width:15px!important\" width=\"15\" height=\"100%\"></td>\n" +
                    "                                                    </tr>\n" +
                    "                                                    </tbody></table>\n" +
                    "                                            </td>\n" +
                    "                                        </tr>\n" +
                    "                                        </tbody></table>\n" +
                    "                                </th>\n" +
                    "                            </tr>\n" +
                    "                            </tbody></table>\n" +
                    "                    </td>\n" +
                    "                </tr>\n" +
                    "                </tbody></table>\n" +
                    "            <table width=\"600px\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5\">\n" +
                    "                <tbody><tr style=\"border-color:transparent\">\n" +
                    "                    <td style=\"border-collapse:collapse;border-color:transparent;text-align:center\" align=\"center\">\n" +
                    "                        <div align=\"center\" style=\"color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;padding-bottom:8px;padding-top:8px\">\n" +
                    "                            <p style=\"font-size:11px;line-height:1.5;margin:0;color:#777;font-family:Verdana,Arial,sans-serif\">Enviado a través de</p>\n" +
                    "                            <span>\n" +
                    "                                <a href=\"https://www.upgrade.com.pe/\" style=\"text-decoration:none;color:#24c1ff\" target=\"_blank\">\n" +
                    "                                    Consultancy Grupo Upgrade\n" +
                    "                                </a>\n" +
                    "                    </td>\n" +
                    "                </tr>\n" +
                    "                </tbody></table>\n" +
                    "        </td>\n" +
                    "    </tr>\n" +
                    "    </tbody>\n" +
                    "</table>", true);
            javaMailSender.send(message);
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
        System.out.println("Done");
    }
    
    public String getHeaderMessage()
    {
        return "                                    <table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;background-color:#fff\" bgcolor=\"#FFFFFF\">\n" +
                    "                                        <tbody><tr style=\"border-color:transparent\">\n" +
                    "                                            <td cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;border-color:transparent\">\n" +
                    "                                                <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:#444;font-family:Arial,&quot;Helvetica Neue&quot;,Helvetica,sans-serif;font-size:14px;line-height:1.5;background-color:#fff\" bgcolor=\"#FFFFFF\">\n" +
                    "                                                    <tbody>\n" +
                    "                                                    <tr  style=\"border-color:transparent\">\n" +
                    "                                                        <td style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\">\n" +
                    "                                                        </td>\n" +
                    "                                                        <td  width=\"520\" style=\"border-collapse:collapse;border-color:transparent;vertical-align:top; background: #193d84\" valign=\"top\">\n" +
                    "                                                            <div  style=\"color:#444;font-family:Arial;Helvetica Neue;,Helvetica,sans-serif;font-size:14px;line-height:1.5;display:block;height:40;width:100%\" height=\"40\" width=\"100%\">\n" +
                    "                                                                <img border=\"0\" width=\"250\" height=\"auto\" align=\"left\" alt=\"test-logo\" src=\"https://www.upgrade.com.pe/Principal/img/LogoBlanco.png\" style=\"text-decoration:none;border:0;height:auto;line-height:100%;outline:0;margin:0;display:block\">\n" +
                    "                                                            </div>\n" +
                    "                                                        </td>\n" +
                    "                                                        <td style=\"border-collapse:collapse;border-color:transparent;width:40px!important\" width=\"40\" height=\"100%\"></td>\n" +
                    "                                                    </tr>\n" +
                    "                                                    <tr style=\"border-color:transparent\">\n" +
                    "                                                        <td colspan=\"3\" width=\"100%\" height=\"15\" style=\"border-collapse:collapse;border-color:transparent\"></td>\n" +
                    "                                                    </tr>\n" +
                    "                                                    </tbody>\n" +
                    "                                                </table>\n" +
                    "                                            </td>\n" +
                    "                                        </tr>\n" +
                    "                                        </tbody>\n" +
                    "                                    </table>\n" ;
    }

}
