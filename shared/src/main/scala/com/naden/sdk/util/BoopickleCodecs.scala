package com.naden.sdk.util

import boopickle.DefaultBasic._
import com.naden.sdk.components._
import com.naden.sdk.components.cards._
import com.naden.sdk.components.elements._
import com.naden.sdk.components.lists._
import com.naden.sdk.components.maps._
import com.naden.sdk.components.panels._
import com.naden.sdk.components.structure._
import com.naden.sdk.components.widgets._
import com.naden.sdk.models._
import com.naden.sdk.models.Color
import com.naden.sdk.models.parameters._

object BoopickleCodecs {

//	implicit val borderAll: Pickler[Border.All.type] = PicklerGenerator.generatePickler[ImageCard]
//
//	implicit val border: Pickler[Border] = compositePickler[Border].
//		addConcreteType[Border.All.type].
//		addConcreteType[Border.Left.type].
//		addConcreteType[Border.Right.type].
//		addConcreteType[Border.Top.type].
//		addConcreteType[Border.Bottom.type]
//
//	implicit val borderSize: Pickler[BorderSize] = PicklerGenerator.generatePickler[BorderSize]
//	implicit val colorAccent: Pickler[ColorAccent] = PicklerGenerator.generatePickler[ColorAccent]
//	implicit val iconPosition: Pickler[IconPosition] = PicklerGenerator.generatePickler[IconPosition]
//	implicit val iconSize: Pickler[IconSize] = PicklerGenerator.generatePickler[IconSize]
//	implicit val objectEvent: Pickler[ObjectEvent] = PicklerGenerator.generatePickler[ObjectEvent]
//	implicit val percentage: Pickler[Percentage] = PicklerGenerator.generatePickler[Percentage]
//	implicit val status: Pickler[Status] = PicklerGenerator.generatePickler[Status]
//	implicit val value: Pickler[Value] = PicklerGenerator.generatePickler[Value]
//
//	// Components
//	implicit val imageCard: Pickler[ImageCard] = PicklerGenerator.generatePickler[ImageCard]
//	implicit val invoiceCard: Pickler[InvoiceCard] = PicklerGenerator.generatePickler[InvoiceCard]
//	implicit val pageCard: Pickler[PageCard] = PicklerGenerator.generatePickler[PageCard]
//	implicit val questionCard: Pickler[QuestionCard] = PicklerGenerator.generatePickler[QuestionCard]
//	implicit val searchResultCard: Pickler[SearchResultCard] = PicklerGenerator.generatePickler[SearchResultCard]
//	implicit val videoCard: Pickler[VideoCard] = PicklerGenerator.generatePickler[VideoCard]
//	implicit val userCard: Pickler[UserCard] = PicklerGenerator.generatePickler[UserCard]
//
//	implicit val badgeElement: Pickler[BadgeElement] = PicklerGenerator.generatePickler[BadgeElement]
//	implicit val buttonElement: Pickler[ButtonElement] = PicklerGenerator.generatePickler[ButtonElement]
//	implicit val checkboxElement: Pickler[CheckboxElement] = PicklerGenerator.generatePickler[CheckboxElement]
//	implicit val colorPickerElement: Pickler[ColorPickerElement] = PicklerGenerator.generatePickler[ColorPickerElement]
//	implicit val fileUploadElement: Pickler[FileUploadElement] = PicklerGenerator.generatePickler[FileUploadElement]
//	implicit val labelElement: Pickler[LabelElement] = PicklerGenerator.generatePickler[LabelElement]
//	implicit val labelStyle: Pickler[LabelStyle] = PicklerGenerator.generatePickler[LabelStyle]
//	implicit val lineSeperatorElement: Pickler[LineSeperatorElement] = PicklerGenerator.generatePickler[LineSeperatorElement]
//	implicit val multiSelectElement: Pickler[MultiSelectElement] = PicklerGenerator.generatePickler[MultiSelectElement]
//	implicit val passwordFieldElement: Pickler[PasswordFieldElement] = PicklerGenerator.generatePickler[PasswordFieldElement]
//	implicit val passwordGeneratorElement: Pickler[PasswordGeneratorElement] = PicklerGenerator.generatePickler[PasswordGeneratorElement]
//	implicit val radioButtonElement: Pickler[RadioButtonElement] = PicklerGenerator.generatePickler[RadioButtonElement]
//	implicit val selectElement: Pickler[SelectElement] = PicklerGenerator.generatePickler[SelectElement]
//	implicit val sliderElement: Pickler[SliderElement] = PicklerGenerator.generatePickler[SliderElement]
//	implicit val sliderStyle: Pickler[SliderStyle] = PicklerGenerator.generatePickler[SliderStyle]
//	implicit val switchElement: Pickler[SwitchElement] = PicklerGenerator.generatePickler[SwitchElement]
//	implicit val tagElement: Pickler[TagElement] = PicklerGenerator.generatePickler[TagElement]
//	implicit val textAreaElement: Pickler[TextAreaElement] = PicklerGenerator.generatePickler[TextAreaElement]
//	implicit val textFieldElement: Pickler[TextFieldElement] = PicklerGenerator.generatePickler[TextFieldElement]
//
//	implicit val commentsList: Pickler[CommentsList] = PicklerGenerator.generatePickler[CommentsList]
//	implicit val eventsList: Pickler[EventsList] = PicklerGenerator.generatePickler[EventsList]
//	implicit val filesList: Pickler[FilesList] = PicklerGenerator.generatePickler[FilesList]
//	implicit val ImagesList: Pickler[ImagesList] = PicklerGenerator.generatePickler[ImagesList]
//	implicit val iagsList: Pickler[TagsList] = PicklerGenerator.generatePickler[TagsList]
//	implicit val tasksList: Pickler[TasksList] = PicklerGenerator.generatePickler[TasksList]
//	implicit val usersList: Pickler[UsersList] = PicklerGenerator.generatePickler[UsersList]
//
//	implicit val googleMap: Pickler[GoogleMap] = PicklerGenerator.generatePickler[GoogleMap]
//	implicit val mapDropAnimation: Pickler[MapDropAnimation] = PicklerGenerator.generatePickler[MapDropAnimation]
//	implicit val mapLayer: Pickler[MapLayer] = PicklerGenerator.generatePickler[MapLayer]
//	implicit val mapPosition: Pickler[MapPosition] = PicklerGenerator.generatePickler[MapPosition]
//	implicit val mapType: Pickler[MapType] = PicklerGenerator.generatePickler[MapType]
//	implicit val mapTypeControlSize: Pickler[MapTypeControlSize] = PicklerGenerator.generatePickler[MapTypeControlSize]
//	implicit val vectorMap: Pickler[VectorMap] = PicklerGenerator.generatePickler[VectorMap]
//
//	implicit val calendarPanel: Pickler[CalendarPanel] = PicklerGenerator.generatePickler[CalendarPanel]
//	implicit val calendarAction: Pickler[CalendarAction] = PicklerGenerator.generatePickler[CalendarAction]
//	implicit val calendarView: Pickler[CalendarView] = PicklerGenerator.generatePickler[CalendarView]
//	implicit val commentsPanel: Pickler[CommentsPanel] = PicklerGenerator.generatePickler[CommentsPanel]
//
//	implicit val accordionStructure: Pickler[AccordionStructure] = PicklerGenerator.generatePickler[AccordionStructure]
//	implicit val gridStructure: Pickler[GridStructure] = PicklerGenerator.generatePickler[GridStructure]
//	implicit val pillsStructure: Pickler[PillsStructure] = PicklerGenerator.generatePickler[PillsStructure]
//	implicit val tabsStructure: Pickler[TabsStructure] = PicklerGenerator.generatePickler[TabsStructure]
//
//	implicit val areaChartWidget: Pickler[AreaChartWidget] = PicklerGenerator.generatePickler[AreaChartWidget]
//	implicit val barChartWidget: Pickler[BarChartWidget] = PicklerGenerator.generatePickler[BarChartWidget]
//	implicit val counterStatsWidget: Pickler[CounterStatsWidget] = PicklerGenerator.generatePickler[CounterStatsWidget]
//	implicit val donutStatsWidget: Pickler[DonutStatsWidget] = PicklerGenerator.generatePickler[DonutStatsWidget]
//	implicit val donutWidget: Pickler[DonutWidget] = PicklerGenerator.generatePickler[DonutWidget]
//	implicit val pieChartWidget: Pickler[PieChartWidget] = PicklerGenerator.generatePickler[PieChartWidget]
//	implicit val progressStatsWidget: Pickler[ProgressStatsWidget] = PicklerGenerator.generatePickler[ProgressStatsWidget]
//	implicit val progressStyle: Pickler[ProgressStyle] = PicklerGenerator.generatePickler[ProgressStyle]
//	implicit val timerWidget: Pickler[TimerWidget] = PicklerGenerator.generatePickler[TimerWidget]
//
//	implicit val components: Pickler[Component] = compositePickler[Component].
//		addConcreteType[EventCard].
//		addConcreteType[ImageCard].
//		addConcreteType[InvoiceCard].
//		addConcreteType[PageCard].
//		addConcreteType[QuestionCard].
//		addConcreteType[SearchResultCard].
//		addConcreteType[VideoCard].
//		addConcreteType[UserCard].
//
//		addConcreteType[BadgeElement].
//		addConcreteType[ButtonElement].
//		addConcreteType[CheckboxElement].
//		addConcreteType[ColorPickerElement].
//		addConcreteType[FileUploadElement].
//		addConcreteType[LineSeperatorElement].
//		addConcreteType[MultiSelectElement].
//		addConcreteType[PasswordFieldElement].
//		addConcreteType[PasswordGeneratorElement].
//		addConcreteType[RadioButtonElement].
//		addConcreteType[SelectElement].
//		addConcreteType[SliderElement].
//		addConcreteType[SwitchElement].
//		addConcreteType[TagElement].
//		addConcreteType[TextAreaElement].
//		addConcreteType[TextFieldElement].
//
//		addConcreteType[CommentsList].
//		addConcreteType[EventsList].
//		addConcreteType[FilesList].
//		addConcreteType[ImagesList].
//		addConcreteType[TagsList].
//		addConcreteType[TasksList].
//		addConcreteType[UsersList].
//
//		addConcreteType[GoogleMap].
//		addConcreteType[VectorMap].
//
//		addConcreteType[CalendarPanel].
//		addConcreteType[CommentsPanel].
//
//		addConcreteType[AccordionStructure].
//		addConcreteType[GridStructure].
//		addConcreteType[PillsStructure].
//		addConcreteType[TabsStructure].
//
//		addConcreteType[AreaChartWidget].
//		addConcreteType[BarChartWidget].
//		addConcreteType[CounterStatsWidget].
//		addConcreteType[DonutStatsWidget].
//		addConcreteType[DonutWidget].
//		addConcreteType[PieChartWidget].
//		addConcreteType[ProgressStatsWidget].
//		addConcreteType[TimerWidget]
//
//	// Models
//	implicit val application: Pickler[Application] = PicklerGenerator.generatePickler[Application]
//	implicit val color: Pickler[Color] = PicklerGenerator.generatePickler[Color]
//	implicit val comment: Pickler[Comment] = PicklerGenerator.generatePickler[Comment]
//	implicit val connection: Pickler[Connection] = PicklerGenerator.generatePickler[Connection]
//	implicit val event: Pickler[Event] = PicklerGenerator.generatePickler[Event]
//	implicit val file: Pickler[File] = PicklerGenerator.generatePickler[File]
//	implicit val group: Pickler[Group] = PicklerGenerator.generatePickler[Group]
//	implicit val image: Pickler[Image] = PicklerGenerator.generatePickler[Image]
//	implicit val invoice: Pickler[Invoice] = PicklerGenerator.generatePickler[Invoice]
//	implicit val paymentMethod: Pickler[PaymentMethod] = PicklerGenerator.generatePickler[PaymentMethod]
//	implicit val paymentStatus: Pickler[PaymentStatus] = PicklerGenerator.generatePickler[PaymentStatus]
//	implicit val layout: Pickler[Layout] = PicklerGenerator.generatePickler[Layout]
//	implicit val page: Pickler[Page] = PicklerGenerator.generatePickler[Page]
//	implicit val panel: Pickler[Panel] = PicklerGenerator.generatePickler[Panel]
//	implicit val panelSlot: Pickler[PanelSlot] = PicklerGenerator.generatePickler[PanelSlot]
//	implicit val question: Pickler[Question] = PicklerGenerator.generatePickler[Question]
//	implicit val session: Pickler[Session] = PicklerGenerator.generatePickler[Session]
//	implicit val tag: Pickler[Tag] = PicklerGenerator.generatePickler[Tag]
//	implicit val task: Pickler[Task] = PicklerGenerator.generatePickler[Task]
//	implicit val user: Pickler[User] = PicklerGenerator.generatePickler[User]
//	implicit val userPageType: Pickler[UserPageType] = PicklerGenerator.generatePickler[UserPageType]
//	implicit val userPanelType: Pickler[UserPanelType] = PicklerGenerator.generatePickler[UserPanelType]
//	implicit val video: Pickler[Video] = PicklerGenerator.generatePickler[Video]
//
//	// Parameters
//	implicit val booleanParameter: Pickler[BooleanParameter] = PicklerGenerator.generatePickler[BooleanParameter]
//	implicit val colorParameter: Pickler[ColorParameter] = PicklerGenerator.generatePickler[ColorParameter]
//	implicit val connectionParameter: Pickler[ConnectionParameter] = PicklerGenerator.generatePickler[ConnectionParameter]
//	implicit val currencyParameter: Pickler[CurrencyParameter] = PicklerGenerator.generatePickler[CurrencyParameter]
//	implicit val dateTimeParameter: Pickler[DateTimeParameter] = PicklerGenerator.generatePickler[DateTimeParameter]
//	implicit val decimalParameter: Pickler[DecimalParameter] = PicklerGenerator.generatePickler[DecimalParameter]
//	implicit val decimalRangeParameter: Pickler[DecimalRangeParameter] = PicklerGenerator.generatePickler[DecimalRangeParameter]
//	implicit val emailParameter: Pickler[EmailParameter] = PicklerGenerator.generatePickler[EmailParameter]
//	implicit val fileParameter: Pickler[FileParameter] = PicklerGenerator.generatePickler[FileParameter]
//	implicit val geoAddressParameter: Pickler[GeoAddressParameter] = PicklerGenerator.generatePickler[GeoAddressParameter]
//	implicit val geoLocationParameter: Pickler[GeoLocationParameter] = PicklerGenerator.generatePickler[GeoLocationParameter]
//	implicit val htmlParameter: Pickler[HtmlParameter] = PicklerGenerator.generatePickler[HtmlParameter]
//	implicit val imageParameter: Pickler[ImageParameter] = PicklerGenerator.generatePickler[ImageParameter]
//	implicit val integerParameter: Pickler[IntegerParameter] = PicklerGenerator.generatePickler[IntegerParameter]
//	implicit val integerRangeParameter: Pickler[IntegerRangeParameter] = PicklerGenerator.generatePickler[IntegerRangeParameter]
//	implicit val ipAddressParameter: Pickler[IPAddressParameter] = PicklerGenerator.generatePickler[IPAddressParameter]
//	implicit val newPasswordParameter: Pickler[NewPasswordParameter] = PicklerGenerator.generatePickler[NewPasswordParameter]
//	implicit val pageParameter: Pickler[PageParameter] = PicklerGenerator.generatePickler[PageParameter]
//	implicit val searchQueryParameter: Pickler[SearchQueryParameter] = PicklerGenerator.generatePickler[SearchQueryParameter]
//	implicit val stringParameter: Pickler[StringParameter] = PicklerGenerator.generatePickler[StringParameter]
//	implicit val tabularDataParameter: Pickler[TabularDataParameter] = PicklerGenerator.generatePickler[TabularDataParameter]
//	implicit val tagsParameter: Pickler[TagsParameter] = PicklerGenerator.generatePickler[TagsParameter]
//	implicit val uriParameter: Pickler[URIParameter] = PicklerGenerator.generatePickler[URIParameter]
//	implicit val userParameter: Pickler[UserParameter] = PicklerGenerator.generatePickler[UserParameter]
//	implicit val videoParameter: Pickler[VideoParameter] = PicklerGenerator.generatePickler[VideoParameter]
//
//	implicit val parameters: Pickler[Parameter] = compositePickler[Parameter].
//		addConcreteType[BooleanParameter].
//		addConcreteType[ColorParameter].
//		addConcreteType[ConnectionParameter].
//		addConcreteType[CurrencyParameter].
//		addConcreteType[DateTimeParameter].
//		addConcreteType[DecimalParameter].
//		addConcreteType[DecimalRangeParameter].
//		addConcreteType[EmailParameter].
//		addConcreteType[FileParameter].
//		addConcreteType[GeoAddressParameter].
//		addConcreteType[GeoLocationParameter].
//		addConcreteType[HtmlParameter].
//		addConcreteType[ImageParameter].
//		addConcreteType[IntegerParameter].
//		addConcreteType[IntegerRangeParameter].
//		addConcreteType[IPAddressParameter].
//		addConcreteType[NewPasswordParameter].
//		addConcreteType[PageParameter].
//		addConcreteType[SearchQueryParameter].
//		addConcreteType[StringParameter].
//		addConcreteType[TabularDataParameter].
//		addConcreteType[TagsParameter].
//		addConcreteType[URIParameter].
//		addConcreteType[UserParameter].
//		addConcreteType[VideoParameter]
}