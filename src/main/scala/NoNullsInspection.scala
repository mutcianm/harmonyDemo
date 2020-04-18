import com.intellij.codeInspection.{InspectionManager, LocalInspectionTool, LocalQuickFix, ProblemDescriptor, ProblemHighlightType}
import com.intellij.psi.PsiElement
import org.jetbrains.plugins.scala.codeInspection.AbstractRegisteredInspection
import org.jetbrains.plugins.scala.extensions.ObjectExt
import org.jetbrains.plugins.scala.lang.psi.api.base.literals.ScNullLiteral

class NoNullsInspection extends AbstractRegisteredInspection {
  override protected def problemDescriptor(element: PsiElement
                                           , maybeQuickFix: Option[LocalQuickFix]
                                           , descriptionTemplate: String
                                           , highlightType: ProblemHighlightType
                                          )(implicit manager: InspectionManager
                                            , isOnTheFly: Boolean): Option[ProblemDescriptor] = {
    for {
      literal <- element.asOptionOf[ScNullLiteral]
      desc <- super.problemDescriptor(literal, descriptionTemplate = "Do not use nulls!!!111")
    } yield desc
  }
}
