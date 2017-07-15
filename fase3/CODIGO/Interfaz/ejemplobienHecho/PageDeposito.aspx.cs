using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace ejemplobienHecho
{
    public partial class PageDeposito : System.Web.UI.Page
    {
        wsBanco.BancoController control = new wsBanco.BancoController();
        protected void Page_Load(object sender, EventArgs e)
        {

        }
        public void limpiarCampos()
        {
            txtCantidad.Text = "";
            txtFecha.Text = "";
            txtCui.Text = "";
            txtCuenta.Text = "";
        }

        protected void btnRegistrar_Click(object sender, EventArgs e)
        {
            try
            {
                if (control.registrarDeposito(int.Parse(txtCantidad.Text), txtFecha.Text, int.Parse(txtCui.Text), int.Parse(txtCuenta.Text)) != null)
                {
                    limpiarCampos();
                    lblMen.Text = "Deposito registrado exitosamente";
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
                wsBanco.deposito depositar = control.buscarDeposito(int.Parse(txtBuscar.Text));
                if (control.buscarDeposito(int.Parse(txtBuscar.Text)) != null)
                {
                    txtCantidad.Text = depositar.deposita.ToString();
                    txtFecha.Text = depositar.fecha.ToString();
                    txtCui.Text = depositar.numeroCui.ToString();
                    txtCuenta.Text = depositar.numeroCuenta.ToString();
                }
                else
                {
                    lblMen.Text = "Cui del cliente no existe, debe registrarlo";
                }
            }
            catch
            {
                lblMen.Text = "Debe llenar el campo de busqueda";
            }

        }

        protected void btnElimina_Click(object sender, ImageClickEventArgs e)
        {
            if (control.eliminarDeposito(int.Parse(txtBuscar.Text)) != null)
            {
                lblMen.Text = "No esta eliminando ningun registro";
            }
            else
            {
                limpiarCampos();
                lblMen.Text = "Registsro eliminado";
            }
        }

        protected void btnCancelar_Click(object sender, EventArgs e)
        {
            limpiarCampos();
        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            control.reporteDeposito();
        }
    }

    }