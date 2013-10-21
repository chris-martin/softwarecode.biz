package views

import controllers.routes

case class Bundle(
  javascripts: Seq[String] = Nil,
  stylesheets: Seq[String] = Nil
) {

  def +(that: Bundle): Bundle =
    Bundle(
      javascripts = javascripts ++ that.javascripts,
      stylesheets = stylesheets ++ that.stylesheets
    )

}

object Bundle {

  def stylesheets(stylesheets: String*): Bundle =
    Bundle(stylesheets = stylesheets)

  def javascripts(javascripts: String*): Bundle =
    Bundle(javascripts = javascripts)

  val jquery =
    javascripts(routes.Assets.at("javascripts/jquery-1.9.0.min.js").url)

}
