using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Prac8
{
    public partial class Labels : System.Web.UI.UserControl
    {
        public string strName;
        public DateTime dt;
        protected void Page_Load(object sender, EventArgs e)
        {
            lblUserName.Text = "You logged on as " + strName;
            lblTime.Text = "You logged on at " + dt.ToString();

        }
    }
}