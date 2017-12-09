package com.naden.namaste.ui.components.lists

import com.naden.namaste.models.User
import com.thoughtworks.binding.{Binding, dom}
import org.scalajs.dom.html.Div

object UsersList {

  @dom
  def apply(title: String,
            icon: String,
            users: List[User],
            showPosition: Boolean,
            showOnline: Boolean,
            showMessenging: Boolean): Binding[Div] = {
    //    <div class="panel panel-body">
    //        <ul class="media-list">
    //            <li class="media-header text-muted">Team leaders</li>
    //
    //            <li class="media">
    //                <div class="media-left media-middle">
    //                    <a href="#">
    //                        <img src="assets/images/placeholder.jpg" class="img-circle img-md" alt="">
    //                        </a>
    //                    </div>
    //
    //                    <div class="media-body">
    //                        <div class="media-heading text-semibold">James Alexander</div>
    //                        <span class="text-muted">Development</span>
    //                    </div>
    //
    //                    <div class="media-right media-middle">
    //                        <ul class="icons-list text-nowrap">
    //                            <li class="dropdown">
    //                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="icon-menu9"></i></a>
    //
    //                                <ul class="dropdown-menu dropdown-menu-right">
    //                                    <li><a href="#"><i class="icon-comment-discussion pull-right"></i> Start chat</a></li>
    //                                    <li><a href="#"><i class="icon-phone2 pull-right"></i> Make a call</a></li>
    //                                    <li><a href="#"><i class="icon-mail5 pull-right"></i> Send mail</a></li>
    //                                    <li class="divider"></li>
    //                                    <li><a href="#"><i class="icon-statistics pull-right"></i> Statistics</a></li>
    //                                </ul>
    //                            </li>
    //                        </ul>
    //                    </div>
    //                </li>
    //            </ul>
    //        </div>

    <div></div>
  }
}