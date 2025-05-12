using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace P6
{
    public partial class WebForm1 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            lblVisitor.Text = Application["visitor"].ToString();
            lblTime.Text = Session["time"].ToString();

            if (Request.Cookies["Theme"] != null)
            {
                Session["SelectedCss"] = Request.Cookies["Theme"].Value;
            }
            else
            {
                Session["SelectedCss"] = "";
            }
        }

        protected void btnApply_Click(object sender, EventArgs e)
        {
            Session["SelectedCss"] = DropDownList1.SelectedValue + ".css";
            // Special.css/Standrad.css

            HttpCookie cookie = new HttpCookie("Theme");
            if (chkRemember.Checked)
            {
                //add Theme Selection -> cookie
                cookie.Value = Session["SelectedCss"].ToString();
                Response.Cookies.Add(cookie);
            }
            else
            {
                // remove cookie
                Response.Cookies["Theme"].Expires = DateTime.Now.AddDays(-1);
                Response.Cookies.Add(cookie);
            }
        }
    }
}