using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace ejemplobienHecho
{
    public partial class pageReporteGerencial : System.Web.UI.Page
    {
        wsBanco.BancoController control = new wsBanco.BancoController();
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btnProductos_Click(object sender, EventArgs e)
        {
            control.reporteproducto();
        }

        protected void Button2_Click(object sender, EventArgs e)
        {
            control.reportePatrocinador();
        }
    }
}