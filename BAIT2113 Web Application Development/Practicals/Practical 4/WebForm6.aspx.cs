using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data.SqlClient;
using System.Configuration;
using System.Configuration.Provider;
using System.Xml.Linq;

namespace P4
{
    public partial class WebForm6 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btnInsert_Click(object sender, EventArgs e)
        {
            string strCon = ConfigurationManager.ConnectionStrings["NWConnectionString"].ConnectionString;
            SqlConnection con = new SqlConnection(strCon);
            con.Open();

            string strCmd = "Insert Into Products (ProductName, Discontinued) VALUES (@Pname, @Discontinued)";
            SqlCommand cmd = new SqlCommand(strCmd, con);
            cmd.Parameters.AddWithValue("@Pname", txtProdName.Text);

            Boolean blnDisc = false;
            if (rblDiscontinued.SelectedValue == "true")
            {
                blnDisc = true;
            }
            else if (rblDiscontinued.SelectedValue == "false")
            {
                blnDisc = false;
            }
            cmd.Parameters.AddWithValue("@Discontinued", blnDisc);

            int intResult = cmd.ExecuteNonQuery();

            if (intResult > 0)
            {
                lblMsg.Text = "Insert Successfully.";
            }
            else
            {
                lblMsg.Text = "Failed to insert the record.";
            }
            con.Close();
        }
    }
}