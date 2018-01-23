package com.naden.sdk.util

object CirceCodecs {

//	implicit def decodeComponent: Decoder[Component] = Decoder.instance[Component] { c =>
//		val content = c.downField("component").success.get
//		c.downField("name").as[String].getOrElse(throw new Exception("Component type not found")).toLowerCase match {
//			case "eventcard" => deriveDecoder[EventCard].apply(content)
//			case "imagecard" => deriveDecoder[ImageCard].apply(content)
//			case "invoicecard" => deriveDecoder[InvoiceCard].apply(content)
//			case "pagecard" => deriveDecoder[PageCard].apply(content)
//			case "questioncard" => deriveDecoder[QuestionCard].apply(content)
//			case "searchresultcard" => deriveDecoder[SearchResultCard].apply(content)
//			case "usercard" => deriveDecoder[UserCard].apply(content)
//			case "videocard" => deriveDecoder[VideoCard].apply(content)
//			case "badgeelement" => deriveDecoder[BadgeElement].apply(content)
//			case "buttonelement" => deriveDecoder[ButtonElement].apply(content)
//			case "checkboxelement" => deriveDecoder[CheckboxElement].apply(content)
//			case "colorpickerelement" => deriveDecoder[ColorPickerElement].apply(content)
//			case "fileuploadelement" => deriveDecoder[FileUploadElement].apply(content)
//			case "labelelement" => deriveDecoder[LabelElement].apply(content)
//			case "lineseperatorelement" => deriveDecoder[LineSeperatorElement].apply(content)
//			case "multiselectelement" => deriveDecoder[MultiSelectElement].apply(content)
//			case "passwordfieldelement" => deriveDecoder[PasswordFieldElement].apply(content)
//			case "passwordgeneratorelement" => deriveDecoder[PasswordGeneratorElement].apply(content)
//			case "radiobuttonelement" => deriveDecoder[RadioButtonElement].apply(content)
//			case "selectelement" => deriveDecoder[SelectElement].apply(content)
//			case "sliderelement" => deriveDecoder[SliderElement].apply(content)
//			case "switchelement" => deriveDecoder[SwitchElement].apply(content)
//			case "tagelement" => deriveDecoder[TagElement].apply(content)
//			case "textareaelement" => deriveDecoder[TextAreaElement].apply(content)
//			case "textfieldelement" => deriveDecoder[TextFieldElement].apply(content)
//			case "commentslist" => deriveDecoder[CommentsList].apply(content)
//			case "eventslist" => deriveDecoder[EventsList].apply(content)
//			case "fileslist" => deriveDecoder[FilesList].apply(content)
//			case "imageslist" => deriveDecoder[ImagesList].apply(content)
//			case "tagslist" => deriveDecoder[TagsList].apply(content)
//			case "taskslist" => deriveDecoder[TasksList].apply(content)
//			case "userslist" => deriveDecoder[UsersList].apply(content)
//			case "googlemap" => deriveDecoder[GoogleMap].apply(content)
//			case "vectormap" => deriveDecoder[VectorMap].apply(content)
//			case "calendarpanel" => deriveDecoder[CalendarPanel].apply(content)
//			case "commentspanel" => deriveDecoder[CommentsPanel].apply(content)
//			case "searchresultspanel" => deriveDecoder[SearchResultsPanel].apply(content)
//			case "timerpanel" => deriveDecoder[TimerPanel].apply(content)
//			case "accordionstructure" => deriveDecoder[AccordionStructure].apply(content)
//			case "gridstructure" => deriveDecoder[GridStructure].apply(content)
//			case "pillsstructure" => deriveDecoder[PillsStructure].apply(content)
//			case "tabsstructure" => deriveDecoder[TabsStructure].apply(content)
//			case "areachartwidget" => deriveDecoder[AreaChartWidget].apply(content)
//			case "barchartwidget" => deriveDecoder[BarChartWidget].apply(content)
//			case "counterstatswidget" => deriveDecoder[CounterStatsWidget].apply(content)
//			case "donutstatswidget" => deriveDecoder[DonutStatsWidget].apply(content)
//			case "donutwidget" => deriveDecoder[DonutWidget].apply(content)
//			case "piechartwidget" => deriveDecoder[PieChartWidget].apply(content)
//			case "progressstatswidget" => deriveDecoder[ProgressStatsWidget].apply(content)
//			case "timerwidget" => deriveDecoder[TimerWidget].apply(content)
//		}
//	}
//
//	implicit def encodeComponent: Encoder[Component] = Encoder.instance[Component] { component =>
//
//		val json = component.getClass.getName match {
//
//			case "eventcard" => deriveEncoder[EventCard].apply(component.asInstanceOf[EventCard])
//			case "imagecard" => deriveEncoder[ImageCard].apply(component.asInstanceOf[ImageCard])
//			case "invoicecard" => deriveEncoder[InvoiceCard].apply(component.asInstanceOf[InvoiceCard])
//			case "pagecard" => deriveEncoder[PageCard].apply(component.asInstanceOf[PageCard])
//			case "questioncard" => deriveEncoder[QuestionCard].apply(component.asInstanceOf[QuestionCard])
//			case "searchresultcard" => deriveEncoder[SearchResultCard].apply(component.asInstanceOf[SearchResultCard])
//			case "usercard" => deriveEncoder[UserCard].apply(component.asInstanceOf[UserCard])
//			case "videocard" => deriveEncoder[VideoCard].apply(component.asInstanceOf[VideoCard])
//			case "badgeelement" => deriveEncoder[BadgeElement].apply(component.asInstanceOf[BadgeElement])
//			case "buttonelement" => deriveEncoder[ButtonElement].apply(component.asInstanceOf[ButtonElement])
//			case "checkboxelement" => deriveEncoder[CheckboxElement].apply(component.asInstanceOf[CheckboxElement])
//			case "colorpickerelement" => deriveEncoder[ColorPickerElement].apply(component.asInstanceOf[ColorPickerElement])
//			case "fileuploadelement" => deriveEncoder[FileUploadElement].apply(component.asInstanceOf[FileUploadElement])
//			case "labelelement" => deriveEncoder[LabelElement].apply(component.asInstanceOf[LabelElement])
//			case "lineseperatorelement" => deriveEncoder[LineSeperatorElement].apply(component.asInstanceOf[LineSeperatorElement])
//			case "multiselectelement" => deriveEncoder[MultiSelectElement].apply(component.asInstanceOf[MultiSelectElement])
//			case "passwordfieldelement" => deriveEncoder[PasswordFieldElement].apply(component.asInstanceOf[PasswordFieldElement])
//			case "passwordgeneratorelement" => deriveEncoder[PasswordGeneratorElement].apply(component.asInstanceOf[PasswordGeneratorElement])
//			case "radiobuttonelement" => deriveEncoder[RadioButtonElement].apply(component.asInstanceOf[RadioButtonElement])
//			case "selectelement" => deriveEncoder[SelectElement].apply(component.asInstanceOf[SelectElement])
//			case "sliderelement" => deriveEncoder[SliderElement].apply(component.asInstanceOf[SliderElement])
//			case "switchelement" => deriveEncoder[SwitchElement].apply(component.asInstanceOf[SwitchElement])
//			case "tagelement" => deriveEncoder[TagElement].apply(component.asInstanceOf[TagElement])
//			case "textareaelement" => deriveEncoder[TextAreaElement].apply(component.asInstanceOf[TextAreaElement])
//			case "textfieldelement" => deriveEncoder[TextFieldElement].apply(component.asInstanceOf[TextFieldElement])
//			case "commentslist" => deriveEncoder[CommentsList].apply(component.asInstanceOf[CommentsList])
//			case "eventslist" => deriveEncoder[EventsList].apply(component.asInstanceOf[EventsList])
//			case "fileslist" => deriveEncoder[FilesList].apply(component.asInstanceOf[FilesList])
//			case "imageslist" => deriveEncoder[ImagesList].apply(component.asInstanceOf[ImagesList])
//			case "tagslist" => deriveEncoder[TagsList].apply(component.asInstanceOf[TagsList])
//			case "taskslist" => deriveEncoder[TasksList].apply(component.asInstanceOf[TasksList])
//			case "userslist" => deriveEncoder[UsersList].apply(component.asInstanceOf[UsersList])
//			case "googlemap" => deriveEncoder[GoogleMap].apply(component.asInstanceOf[GoogleMap])
//			case "vectormap" => deriveEncoder[VectorMap].apply(component.asInstanceOf[VectorMap])
//			case "calendarpanel" => deriveEncoder[CalendarPanel].apply(component.asInstanceOf[CalendarPanel])
//			case "commentspanel" => deriveEncoder[CommentsPanel].apply(component.asInstanceOf[CommentsPanel])
//			case "searchresultspanel" => deriveEncoder[SearchResultsPanel].apply(component.asInstanceOf[SearchResultsPanel])
//			case "timerpanel" => deriveEncoder[TimerPanel].apply(component.asInstanceOf[TimerPanel])
//			case "accordionstructure" => deriveEncoder[AccordionStructure].apply(component.asInstanceOf[AccordionStructure])
//			case "gridstructure" => deriveEncoder[GridStructure].apply(component.asInstanceOf[GridStructure])
//			case "pillsstructure" => deriveEncoder[PillsStructure].apply(component.asInstanceOf[PillsStructure])
//			case "tabsstructure" => deriveEncoder[TabsStructure].apply(component.asInstanceOf[TabsStructure])
//			case "areachartwidget" => deriveEncoder[AreaChartWidget].apply(component.asInstanceOf[AreaChartWidget])
//			case "barchartwidget" => deriveEncoder[BarChartWidget].apply(component.asInstanceOf[BarChartWidget])
//			case "counterstatswidget" => deriveEncoder[CounterStatsWidget].apply(component.asInstanceOf[CounterStatsWidget])
//			case "donutstatswidget" => deriveEncoder[DonutStatsWidget].apply(component.asInstanceOf[DonutStatsWidget])
//			case "donutwidget" => deriveEncoder[DonutWidget].apply(component.asInstanceOf[DonutWidget])
//			case "piechartwidget" => deriveEncoder[PieChartWidget].apply(component.asInstanceOf[PieChartWidget])
//			case "progressstatswidget" => deriveEncoder[ProgressStatsWidget].apply(component.asInstanceOf[ProgressStatsWidget])
//			case "timerwidget" => deriveEncoder[TimerWidget].apply(component.asInstanceOf[TimerWidget])
//		}
//
//		Json.obj("type" -> component.getClass.getName.asJson, "component" -> json)
//	}
//
//	implicit val decodeLocalDateTime: Decoder[LocalDateTime] = Decoder.decodeLong.emap { long => Either.catchNonFatal(DateUtils.fromMillis(long)).leftMap(_ => "Malformed Money")}
//	implicit val decodeMoney: Decoder[Money] = Decoder.decodeString.emap { str => Money(str).toEither.leftMap(_ => "Malformed Money")}
//	implicit val decodePageType: Decoder[PageType] = Decoder.decodeString.emap { str => Either.catchNonFatal(ReflectUtils.classForName[PageType](str)).leftMap(_ => "Malformed Page Type")}
//	implicit val decodePanelType: Decoder[PanelType] = Decoder.decodeString.emap { str => Either.catchNonFatal(ReflectUtils.classForName[PanelType](str)).leftMap(_ => "Malformed Panel Type") }
//	implicit val decodeUri: Decoder[URI] = Decoder.decodeString.emap { str => Either.catchNonFatal(URI.create(str)).leftMap(_ => "Malformed URL") }
//	implicit val decodeUuid: Decoder[UUID] = Decoder.decodeString.emap { str => Either.catchNonFatal(UUID.fromString(str)).leftMap(_ => "Malformed UUID")}
//
//	implicit val encodeLocalDateTime: Encoder[LocalDateTime] = Encoder.encodeLong.contramap[LocalDateTime](DateUtils.toMillis)
//	implicit val encodeMoney: Encoder[Money] = Encoder.encodeString.contramap[Money](_.toString)
//	implicit val encodePageType: Encoder[PageType] = Encoder.encodeString.contramap[PageType](_.getClass.getName)
//	implicit val encodePanelType: Encoder[PanelType] = Encoder.encodeString.contramap[PanelType](_.getClass.getName)
//	implicit val encodeUri: Encoder[URI] = Encoder.encodeString.contramap[URI](_.toString)
//	implicit val encodeUuid: Encoder[UUID] = Encoder.encodeString.contramap[UUID](_.toString)


	// TODO
	//	implicit def decodeParameterList[A](implicit ev: deriveDecoder[A]): deriveDecoder[ListParameter[A]] =
	//		derivederiveDecoder[ListParameter[A]]


	// TODO
	//	implicit def encodeParameterList[A](implicit ev: deriveEncoder[[A]): deriveEncoder[[ListParameter[A]] =
	//		derivederiveEncoder[[ListParameter[A]]
}