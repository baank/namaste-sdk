package com.naden.sdk.models

import boopickle.Default._
import com.naden.sdk.components.cards._
import com.naden.sdk.components.elements._
import com.naden.sdk.components.lists._
import com.naden.sdk.components.maps._
import com.naden.sdk.components.panels._
import com.naden.sdk.components.structure._
import com.naden.sdk.components.widgets._

trait Component {}

object Component {
	implicit val components: Pickler[Component] = compositePickler[Component].
		addConcreteType[EventCard].
		addConcreteType[ImageCard].
		addConcreteType[InvoiceCard].
		addConcreteType[PageCard].
		addConcreteType[QuestionCard].
		addConcreteType[SearchResultCard].
		addConcreteType[VideoCard].
		addConcreteType[UserCard].

		addConcreteType[BadgeElement].
		addConcreteType[ButtonElement].
		addConcreteType[CheckboxElement].
		addConcreteType[ColorPickerElement].
		addConcreteType[FileUploadElement].
		addConcreteType[LineSeperatorElement].
		addConcreteType[MultiSelectElement].
		addConcreteType[PasswordFieldElement].
		addConcreteType[PasswordGeneratorElement].
		addConcreteType[RadioButtonElement].
		addConcreteType[SelectElement].
		addConcreteType[SliderElement].
		addConcreteType[SwitchElement].
		addConcreteType[TagElement].
		addConcreteType[TextAreaElement].
		addConcreteType[TextFieldElement].

		addConcreteType[CommentsList].
		addConcreteType[EventsList].
		addConcreteType[FilesList].
		addConcreteType[ImagesList].
		addConcreteType[TagsList].
		addConcreteType[TasksList].
		addConcreteType[UsersList].

		addConcreteType[GoogleMap].
		addConcreteType[VectorMap].

		addConcreteType[CalendarPanel].
		addConcreteType[CommentsPanel].

		addConcreteType[AccordionStructure].
		addConcreteType[GridStructure].
		addConcreteType[PillsStructure].
		addConcreteType[TabsStructure].

		addConcreteType[AreaChartWidget].
		addConcreteType[BarChartWidget].
		addConcreteType[CounterStatsWidget].
		addConcreteType[DonutStatsWidget].
		addConcreteType[DonutWidget].
		addConcreteType[PieChartWidget].
		addConcreteType[ProgressStatsWidget].
		addConcreteType[TimerWidget]
}