using System;
using System.Collections;
using System.Configuration;
using System.Data;
using System.Web;
using System.Web.Security;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.UI.WebControls.WebParts;
using System.Web.UI.HtmlControls;

public partial class DefaultMaster : System.Web.UI.MasterPage
{
    protected void Page_Load(object sender, EventArgs e)
    {
        string strGender = "";
        if (Request.Cookies["Gender"] != null)
        {
            strGender = Request.Cookies["Gender"].Value;
        }
        Control ctrAd = new Control();
        
        if(strGender == "F")
        {
            ctrAd = LoadControl("female.ascx");
        }
        else if (strGender == "M")
        {
            ctrAd = LoadControl("male.ascx");
        }
        else
        {
            ctrAd = LoadControl("general.ascx");
        }
        contentAd.Controls.Add(ctrAd);  
        


    }
    protected void ImageButton1_Click(object sender, ImageClickEventArgs e)
    {
        Response.Redirect("Default.aspx");
    }
    protected void ImageButton2_Click(object sender, ImageClickEventArgs e)
    {
        Response.Redirect("Shop.aspx");
    }
    protected void ImageButton3_Click(object sender, ImageClickEventArgs e)
    {
        Response.Redirect("Contact.aspx");
    }
}
