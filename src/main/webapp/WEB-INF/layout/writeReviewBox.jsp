<%@ include file="/WEB-INF/layout/taglibs.jsp"%>
<div class="ui-widget infoBoxContainer">
    <div class="ui-widget-header infoBoxHeading">
        <a href="<c:url value="/reviews"/>">Reviews</a>
    </div>
    <table border="0" cellspacing="0" cellpadding="2" class="ui-widget-content infoBoxContents">
        <tr>
            <td><a href="<c:url value="/review/write/product/${product.productDescription.product.id}"/>">
                <img src="images/box_write_review.gif" alt="Write Review" title="Write Review" width="50" height="50" />
            </a>
            </td>
            <td>
                <a href="<c:url value="/review/write/product/${product.productDescription.product.id}"/>">Write a review on this product!</a>
            </td>
        </tr>
    </table>
</div>
