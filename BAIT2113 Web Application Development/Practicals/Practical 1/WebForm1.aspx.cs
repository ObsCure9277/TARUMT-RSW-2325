using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace P1
{
    public partial class WebForm1 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            txtName.Focus();
   
           // btnSubmit.Focus();
        }

        protected void btnSubmit_Click(object sender, EventArgs e)
        {
            string strName = txtName.Text;
            string strProgram = ddlProgram.SelectedItem.ToString() +
                " (" + ddlProgram.SelectedValue.ToString() + ")";

       
            lblDisplay.Text = "Welcome " + strName + " from " + strProgram;
        }

        protected void btnTest_Click(object sender, EventArgs e)
        {

        }
    }
}