using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace ejemplobienHecho
{
    public partial class pageRegistrarProducto : System.Web.UI.Page
    {
        wsBanco.BancoController control = new wsBanco.BancoController();
        protected void Page_Load(object sender, EventArgs e)
        {

        }
        public void limpiarCampos()
        {
            txtNombre.Text = "";
            txtProveedor.Text = "";
        }
        protected void btnRegistrar_Click(object sender, EventArgs e)
        {
            try
            {
                if (control.registrarProducto(txtNombre.Text,int.Parse(txtProveedor.Text)) != null)
                {
                    limpiarCampos();
                    lblMen.Text = "Producto registrado exitosamente";
                }
                else
                {
                    lblMen.Text = "Debe llenar todos los campos";
                }
            }
            catch
            {
                lblMen.Text = "tipo de dato incorrecto ingresado";
            }
        }

        protected void btnBuscar_Click(object sender, ImageClickEventArgs e)
        {
            try
            {
                wsBanco.producto producto = control.buscarProducto(txtBuscar.Text);
                if (control.buscarProducto(txtBuscar.Text) != null)
                {
                    txtNombre.Text = producto.nombre;
                    txtProveedor.Text = producto.idPatrocinador.ToString();
                    //ddlModalidad.SelectedIndex = ddlModalidad.Items.IndexOf(ddlModalidad.Items.FindByValue(prestar.modalidad.ToString()));
                }
                else
                {
                    lblMen.Text = "nombre del producto no existe, debe registrarlo";
                }
            }
            catch
            {
                lblMen.Text = "Debe llenar el campo de busqueda";
            }
        }

        protected void btnCancelar_Click(object sender, EventArgs e)
        {
            limpiarCampos();
        }

        protected void btnReporte_Click(object sender, ImageClickEventArgs e)
        {

        }
    }
}