// This is a generated file. Not intended for manual editing.
package io.github.riej.lsl.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static io.github.riej.lsl.psi.LslTypes.*;
import io.github.riej.lsl.psi.*;
import io.github.riej.lsl.LslPrimitiveType;

public class LslListExprImpl extends LslExpressionImpl implements LslListExpr {

  public LslListExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull LslVisitor visitor) {
    visitor.visitListExpr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LslVisitor) accept((LslVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<LslExpression> getExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LslExpression.class);
  }

  @Override
  @NotNull
  public PsiElement getBracketsLeft() {
    return findNotNullChildByType(BRACKETS_LEFT);
  }

  @Override
  @Nullable
  public PsiElement getBracketsRight() {
    return findChildByType(BRACKETS_RIGHT);
  }

  @Override
  @NotNull
  public LslPrimitiveType getPrimitiveType() {
    return LslPsiImplUtil.getPrimitiveType(this);
  }

}
